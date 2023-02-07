package com.biztec.crytonitebasicdragdrop;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;

class PannableCanvas extends Pane {
    DoubleProperty myScale = new SimpleDoubleProperty(1.0);

    public PannableCanvas() {
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        double x = primaryScreenBounds.getWidth() * 5;
        double y = primaryScreenBounds.getWidth() * 5;

        setPrefSize(x, y);
        setTranslateY(-y/2);
        setTranslateX(-x/2);

        setStyle("-fx-background-color: lightgrey, linear-gradient(from 2.5px 0px to 52.5px  0px, repeat, #BBBBBB 5%, transparent 5%), linear-gradient(from 0px 2.5px to  0px 52.5px, repeat, #BBBBBB 5%, transparent 5%); -fx-border-color: lightgrey;");

        scaleXProperty().bind(myScale);
        scaleYProperty().bind(myScale);
    }

    public double getScale() {
        return myScale.get();
    }

    public void setScale( double scale) {
        myScale.set(scale);
    }

    public void setPivot( double x, double y) {
        setTranslateX(getTranslateX()-x);
        setTranslateY(getTranslateY()-y);
    }
}
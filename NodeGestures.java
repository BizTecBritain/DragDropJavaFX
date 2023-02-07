package com.biztec.crytonitebasicdragdrop;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;


class NodeGestures {

    private final DragContext nodeDragContext = new DragContext();

    PannableCanvas canvas;

    public NodeGestures(PannableCanvas canvas) {
        this.canvas = canvas;
    }

    public EventHandler<MouseEvent> getOnMousePressedEventHandler() {
        return onMousePressedEventHandler;
    }

    public EventHandler<MouseEvent> getOnMouseDraggedEventHandler() {
        return onMouseDraggedEventHandler;
    }

    private final EventHandler<MouseEvent> onMousePressedEventHandler = event -> {
        if(!event.isPrimaryButtonDown())
            return;

        nodeDragContext.mouseAnchorX = event.getSceneX();
        nodeDragContext.mouseAnchorY = event.getSceneY();

        Node node = (Node) event.getSource();

        nodeDragContext.translateAnchorX = node.getTranslateX();
        nodeDragContext.translateAnchorY = node.getTranslateY();
    };

    private final EventHandler<MouseEvent> onMouseDraggedEventHandler = event -> {
        if (!event.isPrimaryButtonDown())
            return;

        double scale = canvas.getScale();

        Node node = (Node) event.getSource();

        node.setTranslateX(nodeDragContext.translateAnchorX + ((event.getSceneX() - nodeDragContext.mouseAnchorX) / scale));
        node.setTranslateY(nodeDragContext.translateAnchorY + ((event.getSceneY() - nodeDragContext.mouseAnchorY) / scale));

        event.consume();
    };
}
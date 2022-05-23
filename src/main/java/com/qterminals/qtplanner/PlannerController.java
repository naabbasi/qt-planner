package com.qterminals.qtplanner;

import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Screen;

public class PlannerController {
    @FXML
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private double startX;
    private double startY;

    private double lastX;
    private double lastY;

    private double newX;
    private double newY;

    public void initialize() {
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();

        canvas.setWidth(screenBounds.getWidth());
        canvas.setHeight(screenBounds.getHeight() - 24);
        graphicsContext = canvas.getGraphicsContext2D();

        canvas.setOnMousePressed(e -> {
            lastX = e.getX();
            lastY = e.getY();

            startX = e.getX();
            startY = e.getY();

            graphicsContext.clearRect(startX, startY, newX, newY);
        });

        canvas.setOnMouseDragged(e->{
            double size = 5;
            double x = e.getX();
            double y = e.getY();

            newX = e.getX();
            newY = e.getY();

            graphicsContext.setLineWidth(size);
            graphicsContext.setStroke(Color.LIMEGREEN);
            lastX = x;
            lastY = y;

            //graphicsContext.fillRect(lastX, lastY, 10, 10);
            System.out.println("X: " + lastX + " Y: " + lastY + " X: " + x + " Y: " + y);
        });

        canvas.setOnMouseReleased(e -> {
            graphicsContext.fillRect(startX, startY, newX, newY);
        });
    }
}
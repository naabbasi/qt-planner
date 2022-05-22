package com.qterminals.qtplanner;

import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;

public class PlannerController {
    @FXML
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private double lastX ;
    private double lastY ;

    public void initialize() {
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();

        canvas.setWidth(screenBounds.getWidth());
        canvas.setHeight(screenBounds.getHeight() - 24);
        graphicsContext = canvas.getGraphicsContext2D();

        canvas.setOnMousePressed(e -> {
            lastX = e.getX();
            lastY = e.getY();
        });

        canvas.setOnMouseDragged(e->{
            double size = 5;
            double x = e.getX();
            double y = e.getY();

            graphicsContext.setLineWidth(size);
            graphicsContext.setStroke(Color.RED);
            graphicsContext.strokeLine(lastX, lastY, x, y);
            lastX = x ;
            lastY = y ;
        });
    }

    private Canvas getCanvas(Group group) {

        // Creating canvas object for add an image
        Canvas canvasRef = new Canvas(750, 500);
        group.getChildren().add(canvasRef);

        // adding 2d graphics to the canvas object
        GraphicsContext graphicContext = canvasRef.getGraphicsContext2D();

        // adding color to the graphic
        graphicContext.setFill(Color.BLUE);
        graphicContext.setStroke(Color.BROWN);
        graphicContext.setLineWidth(3);

        Font theFont = Font.font("Castellar", FontWeight.BOLD, 38);
        graphicContext.setFont(theFont);
        graphicContext.fillText("This is Text Area for Canvas", 61, 52);

        return canvasRef;
    }
}
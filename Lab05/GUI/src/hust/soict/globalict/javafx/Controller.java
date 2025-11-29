package hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class Controller {
    private double lastX, lastY;
    private boolean isDrawing = false;
    private boolean isEraser = false;
    private final Color currentColor = Color.BLACK;
    private final double PEN_SIZE = 4.0;
    private final double ERASER_SIZE = 20.0;

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton eraser, pen;

    @FXML
    private ToggleGroup toolsGroup;

    @FXML
    void drawingAreaMousePressed(MouseEvent event) {
        isDrawing = true;
        lastX = event.getX();
        lastY = event.getY();
        Circle newCircle = new Circle(lastX, lastY, 2, Color.BLACK);
        drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        if (!isDrawing)
            return;

        double currentX = event.getX();
        double currentY = event.getY();

        if (!isEraser) {
            Line line = new Line(lastX, lastY, currentX, currentY);
            line.setStroke(currentColor);
            line.setStrokeWidth(PEN_SIZE);
            drawingAreaPane.getChildren().add(line);

            // Add a circle at the end for smoother line ends
            Circle endCircle = new Circle(currentX, currentY, PEN_SIZE / 2, currentColor);
            drawingAreaPane.getChildren().add(endCircle);
        } else {
            eraseAtPosition(currentX, currentY);
        }

        lastX = currentX;
        lastY = currentY;
    }

    private void eraseAtPosition(double x, double y) {
        drawingAreaPane.getChildren().removeIf(node -> {
            if (node instanceof Circle) {
                Circle circle = (Circle) node;
                double dx = circle.getCenterX() - x;
                double dy = circle.getCenterY() - y;
                return (dx * dx + dy * dy) <= (ERASER_SIZE * ERASER_SIZE);
            } else if (node instanceof Line) {
                Line line = (Line) node;
                double x1 = line.getStartX();
                double y1 = line.getStartY();
                double x2 = line.getEndX();
                double y2 = line.getEndY();

                double A = x - x1;
                double B = y - y1;
                double C = x2 - x1;
                double D = y2 - y1;

                double dot = A * C + B * D;
                double len_sq = C * C + D * D;
                double param = (len_sq != 0) ? dot / len_sq : -1;

                double xx, yy;
                if (param < 0) {
                    xx = x1;
                    yy = y1;
                } else if (param > 1) {
                    xx = x2;
                    yy = y2;
                } else {
                    xx = x1 + param * C;
                    yy = y1 + param * D;
                }

                double dx = x - xx;
                double dy = y - yy;
                return (dx * dx + dy * dy) <= (ERASER_SIZE * ERASER_SIZE);
            }
            return false;
        });
    }

    @FXML
    void drawingAreaMouseReleased(MouseEvent event) {
        isDrawing = false;
    }

    @FXML
    void ClearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void handleEraser(ActionEvent event) {
        isEraser = true;
        toolsGroup.selectToggle(null);
        eraser.setSelected(true);
    }

    @FXML
    void handlePen(ActionEvent event) {
        isEraser = false;
        toolsGroup.selectToggle(null);
        pen.setSelected(true);
    }

}

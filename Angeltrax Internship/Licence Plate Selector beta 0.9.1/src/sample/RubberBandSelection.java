package sample;

import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;

/**
 * DRAG SELECTION
 * Drag rectangle with mouse cursor in order to get selection bounds.
 */
public class RubberBandSelection {

    public double mouseAnchorX;
    public double mouseAnchorY;

    Rectangle rect;
    Rectangle prevSelection;
    javafx.scene.image.ImageView imageViewMain;

    Group rubberBandGroup;


    public Bounds getBounds() {
        return rect.getBoundsInParent();
    }

    public RubberBandSelection(Group group, javafx.scene.image.ImageView imageViewMain) {

        this.rubberBandGroup = group;
        this.imageViewMain = imageViewMain;

        rect = new Rectangle(0, 0, 0, 0);
        rect.setStroke(Color.GOLD);
        rect.setStrokeWidth(1);
        rect.setStrokeLineCap(StrokeLineCap.ROUND);
        rect.setFill(Color.GRAY.deriveColor(0, 1.2, 1, 0.6));

        prevSelection = new Rectangle(0,0,0,0);
        prevSelection.setStroke(Color.ORANGERED);
        prevSelection.setStrokeWidth(1);
        prevSelection.setStrokeLineCap(StrokeLineCap.ROUND);
        prevSelection.setFill(Color.GRAY.deriveColor(0, 1.2, 1, 0.6));

        group.addEventHandler(MouseEvent.MOUSE_PRESSED, onMousePressedEventHandler);
        group.addEventHandler(MouseEvent.MOUSE_DRAGGED, onMouseDraggedEventHandler);
        group.addEventHandler(MouseEvent.MOUSE_RELEASED, onMouseReleasedEventHandler);

    }

    EventHandler<MouseEvent> onMousePressedEventHandler = new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent event) {

            if (imageViewMain.getImage() == null) {
                System.out.println(imageViewMain);
                System.out.println("No Image to select bounds");
                return;
            }

            if (event.isSecondaryButtonDown()) {
                return;
            }

            removeRect(rect);

            rubberBandGroup.getChildren().add(rect);

            // prepare new drag operation
            mouseAnchorX = event.getX();
            mouseAnchorY = event.getY();
        }
    };

    EventHandler<MouseEvent> onMouseDraggedEventHandler = new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent event) {
            double offsetX;
            rect.setY(mouseAnchorY);
            double offsetY;

            if (imageViewMain.getImage() == null) {
                return;
            }

            // check if the mouse event coordinates are outside the bounds of the image view then cancel
            if (imageViewMain.getBoundsInParent().getMinX() >= event.getX()) {
                rect.setX(imageViewMain.getBoundsInParent().getMinX());
                offsetX = mouseAnchorX;
                rect.setWidth(offsetX);
            } else if (imageViewMain.getBoundsInParent().getMaxX() <= event.getX()) {
                rect.setX(mouseAnchorX);
                offsetX = imageViewMain.getBoundsInParent().getMaxX() - mouseAnchorX;
                rect.setWidth(offsetX);
            } else {
                rect.setX(mouseAnchorX);
                offsetX = event.getX() - mouseAnchorX;
                if (offsetX > 0) {
                    rect.setWidth(offsetX);
                } else{
                    rect.setX(event.getX());
                    rect.setWidth(mouseAnchorX - rect.getX());
                }
            }

            if (imageViewMain.getBoundsInParent().getMinY() >= event.getY()) {
                rect.setY(imageViewMain.getBoundsInParent().getMinY());
                offsetY = mouseAnchorY;
                rect.setHeight(offsetY);
            } else if (imageViewMain.getBoundsInParent().getMaxY() <= event.getY()) {
                rect.setY(mouseAnchorY);
                offsetY = imageViewMain.getBoundsInParent().getMaxY() - mouseAnchorY;
                rect.setHeight(offsetY);
            } else {
                rect.setY(mouseAnchorY);
                offsetY = event.getY() - mouseAnchorY;
                if (offsetY > 0) {
                    rect.setHeight(offsetY);
                } else {
                    rect.setY(event.getY());
                    rect.setHeight(mouseAnchorY - rect.getY());
                }
            }
        }
    };


    EventHandler<MouseEvent> onMouseReleasedEventHandler = new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent event) {

            if (imageViewMain.getImage() == null) {

                removeRect(rect);

                return;
            }

            if (event.isSecondaryButtonDown()) {
                return;
            }
        }
    };

    public void removeRect(Rectangle r) {
        r.setX(0);
        r.setY(0);
        r.setHeight(0);
        r.setWidth(0);

        rubberBandGroup.getChildren().remove(r);
    }

    public void setPreviousRectangle(Rectangle r) {
        rubberBandGroup.getChildren().remove(prevSelection);

        prevSelection = r;
        prevSelection.setStroke(Color.ORANGERED);
        prevSelection.setStrokeWidth(1);
        prevSelection.setStrokeLineCap(StrokeLineCap.ROUND);
        prevSelection.setFill(Color.GRAY.deriveColor(0, 1.2, 1, 0.6));

        rubberBandGroup.getChildren().add(r);
    }
}

package View;

import java.awt.Color;
import java.awt.*;

/**
 * ArcModel is the class that draws the outer circle of the Simon game. 
 * This class gives the player a visual representation of a “wheel” shaped game, 
 * like the original Simon game. 
 * It draws an outer circle that is the same color of the background. 
 * This allows for the appearance of a pie shape.
 * This also has the buttons "blink" by changing the color to white temporarily.
 */
public class ArcModel {

    private final int closureType;

    private final double startingAngle;
    private final double extent;

    private Color color;
    private final Color originalColor;

    private final Rectangle rectangle;

    public ArcModel(Color color, Rectangle rectangle, double startingAngle,
            double extent, int closureType) {
        this.color = color;
        this.originalColor = color;
        this.rectangle = rectangle;
        this.startingAngle = startingAngle;
        this.extent = extent;
        this.closureType = closureType;
    }

    public int getClosureType() {
        return closureType;
    }

    public double getStartingAngle() {
        return startingAngle;
    }

    public double getExtent() {
        return extent;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public Color getColor() {
        return color;
    }

    public void brighterColor() {
        this.color = Color.WHITE;
    }

    public void darkerColor() {
        this.color = originalColor;
    }

}
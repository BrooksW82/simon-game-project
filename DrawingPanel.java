package View;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import java.awt.geom.Arc2D;
import javax.swing.*;

/**
 * DrawingPanel takes in the outer shape, created by the ArcModel 
 * class, and draws four different colored rectangles. 
 * The rectangles are set in the foreground of the panel and the outer
 *  circle is hollow in the middle to see the different colors. 
 * This is the shape that is always updated when a button “blinks” 
 * to signal that either the player has pressed the rectangle 
 * or to show the player that Simon has chosen that color.
 */
public class DrawingPanel extends JPanel {

    private static final long serialVersionUID = 70146219705119575L;
    

    public List<ArcModel> segments;
    public int width;

    public DrawingPanel() {
        this.segments = new ArrayList<ArcModel>();

        int margin = 50;
        int diameter = 300;
        //int margin = 75;
        //int diameter = 450;
        
        Rectangle r = new Rectangle(margin, margin, diameter, diameter);

        segments.add(new ArcModel(Color.GREEN, r, 180, 90, Arc2D.PIE));
        segments.add(new ArcModel(Color.BLUE, r, 270, 90, Arc2D.PIE));
        segments.add(new ArcModel(Color.RED, r, 360, 90, Arc2D.PIE));
        segments.add(new ArcModel(Color.YELLOW, r, 90, 90, Arc2D.PIE));

        width = diameter + margin + margin;
        this.setPreferredSize(new Dimension(width, width));
    }

    public void brighterArcModelColor(int index) {
        segments.get(index).brighterColor();
        repaint();
    }

    public void darkerArcModelColor(int index) {
        segments.get(index).darkerColor();
        repaint();
    }

    
/**
 * paintComponent is the function to override when creating a game with a panel and components.
 * This allows for the player to see an updated state of the game.
 *
 * @param  Graphics g -> this is to repaint the model dynamically
 */  
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        for (ArcModel arcModel : segments) {
            g2d.setPaint(arcModel.getColor());
            Rectangle r = arcModel.getRectangle();
            g2d.fill(new Arc2D.Double(r.getX(), r.getY(), r.getWidth(), r
                    .getHeight(), arcModel.getStartingAngle(), arcModel
                    .getExtent(), arcModel.getClosureType()));
        }
    }

}
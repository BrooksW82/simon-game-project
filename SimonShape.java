package View;

import Controller.GameRunnable;
import javax.swing.JFrame;

/**
 * This class ties in the components of the view to easily create and display Simon. 
 * SimonShape also implements the same thread that is created in the main controller class of Simon. 
 * This allows for the buttons to blink and to provide dynamic gameplay for the player.
 */
public class SimonShape implements Runnable {

    public static JFrame frame;
    
    public SimonShape() {
    }

   public static JFrame getFrame() {
	   return frame;
   }
    @Override
    public void run() {
        frame = new JFrame("Simon Says");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DrawingPanel drawingPanel = new DrawingPanel();
        frame.add(drawingPanel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        

        GameRunnable runnable = new GameRunnable(drawingPanel);
        new Thread(runnable).start();
        frame.addMouseListener(runnable);
    }
}
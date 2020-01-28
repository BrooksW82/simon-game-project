package View;

import View.SimonShape;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

/** 
 * This class creates a JFrame when called at the end of a Simon game. 
 * It also calls for the SimonShape frame to close and the menuUI to be visible again. 
 */
public class GameOverUI extends JFrame {

	private JPanel contentPane;

	public GameOverUI() {
		SimonShape.getFrame().dispose();
		menuUI.getPanel().setVisible(true);//panel stuff
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 260, 134);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGameOver = new JLabel("GAME OVER!");
		lblGameOver.setFont(new Font("Sitka Display", Font.BOLD, 36));
		lblGameOver.setBounds(20, 22, 224, 47);
		contentPane.add(lblGameOver);
	}

}
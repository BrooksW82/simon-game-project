package View;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

/** 
 * This class creates a JFrame window when the Simon game ends and the user has a high score to input. 
 * It also calls for the SimonShape frame to close and the menuUI to be visible again. 
 */
public class GameOverHSUI extends JFrame {

	private JPanel contentPane;

	public GameOverHSUI() {
	
		SimonShape.getFrame().dispose();
		menuUI.getPanel().setVisible(true);//panel stuff
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 260, 181);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGameOver = new JLabel("GAME OVER!");
		lblGameOver.setFont(new Font("Sitka Display", Font.BOLD, 37));
		lblGameOver.setBounds(20, 21, 234, 47);
		contentPane.add(lblGameOver);
		
		JLabel lblNewHighScore = new JLabel("NEW HIGH SCORE!");
		lblNewHighScore.setFont(new Font("Sitka Display", Font.BOLD, 14));
		lblNewHighScore.setBounds(61, 79, 130, 14);
		contentPane.add(lblNewHighScore);
	}

}
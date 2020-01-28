package View;

import Controller.GameRunnable;
import Controller.mainMenu;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.*;

/**
 * This class creates a JFrame window for the main menu for the Simon game when called from the mainMenu controller class. 
 * It also acts with action listeners to call other functions to open new JFrames called.
 */
public class menuUI extends JFrame{
	private static JPanel contentPane;
	
	public menuUI() {
		displayWelcomeScreen();
	}
	
	public void displayWelcomeScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 214, 272);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JButton btnEasy = new JButton("Easy");
		btnEasy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//easy represented by the value 1
				GameRunnable.difLevel = 1;
				SwingUtilities.invokeLater(new SimonShape());
				contentPane.setVisible(false);//panel stuff
			}
		});
		btnEasy.setForeground(Color.BLACK);
		btnEasy.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEasy.setBounds(47, 74, 104, 23);
		contentPane.add(btnEasy);
		
		JButton btnModerate = new JButton("Moderate");
		btnModerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//moderate represented by the value 2
				GameRunnable.difLevel = 2;
				SwingUtilities.invokeLater(new SimonShape());
				contentPane.setVisible(false);//panel stuff
			}
		});
		btnModerate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnModerate.setBounds(47, 108, 104, 23);
		contentPane.add(btnModerate);
		
		JButton btnHard = new JButton("Hard");
		btnHard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//hard represented by the value 3
				GameRunnable.difLevel = 3;
				SwingUtilities.invokeLater(new SimonShape());
				contentPane.setVisible(false);//panel stuff
			}
		});
		btnHard.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHard.setBounds(47, 142, 104, 23);
		contentPane.add(btnHard);
		
		JButton btnHighScores = new JButton("High Scores");
		btnHighScores.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mainMenu.viewHighScores();
			}
		});
		btnHighScores.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnHighScores.setBounds(97, 199, 91, 23);
		contentPane.add(btnHighScores);
		
		JLabel lblSimon = new JLabel("SIMON");
		lblSimon.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSimon.setBounds(70, 33, 73, 30);
		contentPane.add(lblSimon);
	}

/**
* This function returns the parent panel. 
* @return	returns the main panel of menuUI JFrame
*/	
	public static JPanel getPanel() {
		return contentPane;
	}
}
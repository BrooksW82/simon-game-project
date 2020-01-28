package View;

import Model.HighScoreStorage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.CardLayout;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.ImageIcon;

public class HighScoreUI extends JFrame {

	private JPanel contentPane;

/** 
 * This class creates a JFrame window for high scores when called from the main menu controller class. 
 * The Frame is set with a card layout for the panes so that navigation stays all within the same Frame. 
 * The content panes retrieve information from the SimonScores.txt arrays housed within the model and 
 * then display show arrays.  
 */
	public HighScoreUI() throws PrinterException {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 236, 220);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel parentPanel = new JPanel();
		parentPanel.setBounds(10, 11, 200, 148);
		contentPane.add(parentPanel);
		parentPanel.setLayout(new CardLayout(0, 0));
		
		JPanel HomePanel = new JPanel();
		parentPanel.add(HomePanel, "name_3876734629688");
		HomePanel.setLayout(null);
		
		JPanel EasyPanel = new JPanel();
		parentPanel.add(EasyPanel, "name_4027141243296");
		EasyPanel.setLayout(null);
		
		JPanel ModeratePanel = new JPanel();
		parentPanel.add(ModeratePanel, "name_439377198870632");
		ModeratePanel.setLayout(null);
		
		JPanel HardPanel = new JPanel();
		parentPanel.add(HardPanel, "name_439381430602003");
		HardPanel.setLayout(null);
		
		
		JButton btnEasyHighScores = new JButton("Easy High Scores");
		btnEasyHighScores.setBounds(28, 25, 143, 21);
		btnEasyHighScores.setFont(new Font("Tahoma", Font.BOLD, 10));
		HomePanel.add(btnEasyHighScores);
		btnEasyHighScores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parentPanel.removeAll();
				parentPanel.add(EasyPanel);
				parentPanel.repaint();
				parentPanel.revalidate();
			}
		});
		
		JTextPane easyHS = new JTextPane();
		easyHS.setBackground(UIManager.getColor("Button.background"));
		easyHS.setFont(new Font("Dialog", Font.BOLD, 12));
		easyHS.setText("Easy High Scores");
		easyHS.setBounds(50, 11, 119, 20);
		EasyPanel.add(easyHS);
		
		JButton btnBack = new JButton("");
		btnBack.setForeground(UIManager.getColor("Button.focus"));
		btnBack.setIcon(new ImageIcon(HighScoreUI.class.getResource("fxvk-backspace-button.png")));
		btnBack.setBounds(157, 125, 43, 23);
		EasyPanel.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parentPanel.removeAll();
				parentPanel.add(HomePanel);
				parentPanel.repaint();
				parentPanel.revalidate();
			}
		});
		JPanel eDisplayPanel = new JPanel();
		eDisplayPanel.setBounds(30, 30, 150, 100);
		EasyPanel.add(eDisplayPanel);
		
//Creates variable and panel to display easy HS 
		String[] easy = HighScoreStorage.getEasyArray();  
		final JList<String> e = new JList<String>(easy);
		e.setSelectedIndex(0);
		eDisplayPanel.add(e);
	
		
		
		
		JButton btnModerateHighScores = new JButton("Moderate High Scores");
		btnModerateHighScores.setBounds(28, 57, 143, 21);
		HomePanel.add(btnModerateHighScores);
		btnModerateHighScores.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnModerateHighScores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				parentPanel.removeAll();
				parentPanel.add(ModeratePanel);
				parentPanel.repaint();
				parentPanel.revalidate();
			}
		});	
		JTextPane ModerateHighSchool = new JTextPane();
		ModerateHighSchool.setBounds(29, 11, 161, 20);
		ModeratePanel.add(ModerateHighSchool);
		ModerateHighSchool.setFont(new Font("Dialog", Font.BOLD, 12));
		ModerateHighSchool.setBackground(UIManager.getColor("Button.background"));
		ModerateHighSchool.setText("Moderate High Scores ");
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(HighScoreUI.class.getResource("fxvk-backspace-button.png")));
		button.setBounds(150, 125, 50, 23);
		ModeratePanel.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parentPanel.removeAll();
				parentPanel.add(HomePanel);
				parentPanel.repaint();
				parentPanel.revalidate();
			}
		});
		JPanel mDisplay = new JPanel();
		mDisplay.setBounds(39, 32, 105, 98);
		ModeratePanel.add(mDisplay);		
	
//Creates variable and panel to display easy HS 
		String[] mod = HighScoreStorage.getModerateArray();
		final JList<String> m = new JList<String>(mod);
		m.setSelectedIndex(0);				
		mDisplay.add(m);
	
		
		
		
		JButton btnHardHighScores = new JButton("Hard High scores");
		btnHardHighScores.setBounds(28, 89, 141, 21);
		HomePanel.add(btnHardHighScores);
		btnHardHighScores.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnHardHighScores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parentPanel.removeAll();
				parentPanel.add(HardPanel);
				parentPanel.repaint();
				parentPanel.revalidate();
			}
		});
		JTextPane txtpnHardScore = new JTextPane();
		txtpnHardScore.setBackground(UIManager.getColor("Button.background"));
		txtpnHardScore.setFont(new Font("Dialog", Font.BOLD, 12));
		txtpnHardScore.setText("Hard High Scores");
		txtpnHardScore.setBounds(50, 11, 170, 20);
		HardPanel.add(txtpnHardScore);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(HighScoreUI.class.getResource("fxvk-backspace-button.png")));
		btnNewButton.setBounds(152, 125, 48, 23);
		HardPanel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parentPanel.removeAll();
				parentPanel.add(HomePanel);
				parentPanel.repaint();
				parentPanel.revalidate();
			}
		});

		JPanel hDisplay = new JPanel();
		hDisplay.setBounds(20, 30, 155, 97);
		HardPanel.add(hDisplay);
	
//Creates variable and panel to display easy HS 
		String[] hard = HighScoreStorage.getHardArray();
		final JList<String> h = new JList<String>(hard);
		h.setSelectedIndex(0);				
		hDisplay.add(h);

	}
}
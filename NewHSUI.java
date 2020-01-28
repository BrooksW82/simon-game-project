package View;

import javax.swing.*;

public class NewHSUI extends JFrame {
	
	
/**
 * This function creates a JFrame with a pane that requests the players initials input. 
 * Once the player inputs the information, the function deletes any unnecessary content 
 * possibly inputed. After checking the information, the function then returns a string 
 * containing the players initials.
 * 
 * @return	string of player initials 
 */		
	static public String getPlayerName() {
	
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	String input = JOptionPane.showInputDialog(frame, 
			                   "Enter Your Initials:", "New High Score!", JOptionPane.PLAIN_MESSAGE);
	
	if(input == null){
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	else {
		boolean flag = true;
		while(flag) {
	    	input = input.replaceAll(" ", "");
	    	if (!input.contains(" "))
	        	flag = false;
		}
		flag = true;
		while(flag) {
	    	input = input.replaceAll(":", "");
	    	if (!input.contains(":"))
	        	flag = false;
		}
	
		if(input.length() > 3) {
			input = input.substring(0, 3);
		}
	}
	
	return input;
	}		        
} 
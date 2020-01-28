package Controller;

import Model.HighScoreStorage;
import View.menuUI;
import View.HighScoreUI;
public class mainMenu {
	
	static HighScoreStorage hs = new HighScoreStorage();
	
/**
*  This function creates and generates the menuUI to be displayed from View
*/	
	public static void start() {
		try {
			menuUI frame = new menuUI();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
/** 
* This function creates and generates the HighScoreUI to be displayed from View
*/	
	public static void viewHighScores() {
		try {
			HighScoreUI HSframe = new HighScoreUI();
			HSframe.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
/**
* Main function for the system, creates a storage object for txt file and calls the 
* start function
*/	
	public static void main(String[] args) {
		HighScoreStorage hs = new HighScoreStorage();
		hs.getCompScores();
		start();
	}	
}
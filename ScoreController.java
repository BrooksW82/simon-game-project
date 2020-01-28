package Controller;

import Model.HighScoreStorage;
import View.NewHSUI;
import Model.HighScores;
import View.GameOverUI;
import View.GameOverHSUI;
public class ScoreController {

/**
 * This function takes in an array and an integer as parameters. It checks if the new players score is
 * a high score or not. The function then calls the appropriate game over UI. If the new player has a 
 * high score, the system requests the players initials. Once acquired, the initials and score are placed 
 * with a new object and inserted into the storage. 
 * 
 * @param arrayName	object array of high score players names and their scores.
 * @param s		new player score that just completed a game
 */	
	public static void isHighScore(HighScores[] arrayName, int s) {
		
		int size = arrayName.length;
		
		if(s <= arrayName[size-1].getScore()) {
			viewGameOver();	
			return;
		}
		else{
			
			viewGameOverHS();
			String name = NewHSUI.getPlayerName();
			HighScores x = new HighScores(s, name);
			
			HighScoreStorage.insertHS(arrayName, x);
		}
	}

/**
* This function is called by the isHighScore function. It creates and generates the GameOverHSUI
* that is within View
*/	
	public static void viewGameOverHS() {
		try {
			GameOverHSUI gohsFrame = new GameOverHSUI();
			gohsFrame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
/**
 * This function is called by the isHighScore function. It creates and generates the GameOverUI
 * that is within View
 */	
	public static void viewGameOver() {
		try {
			GameOverUI goFrame = new GameOverUI();
			goFrame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
package Model;

import Controller.ScoreController;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


public class HighScoreStorage {

// size of the high scores list
	static int size = 5;
	
	// arrays to hold the high scores objects
	static HighScores easy[] = new HighScores[size];
	static HighScores moderate[] = new HighScores[size];
	static HighScores hard[] = new HighScores[size];
	
	public int getSize() {
		return size;
	}
		
 /** 
  * This function iterates through the easy High Score array
  * and turns the score int into a string. It then creates
  * a new string consisting of the name and score with a space. 
  * @return returns an array of strings for display
  */			
	public static String[] getEasyArray() {
		
		String[] arrEasy = new String[size];
		
		for(int i = 0; i < size; i++) {
			String name = easy[i].getName();
			String score = Integer.toString(easy[i].getScore());
			arrEasy[i] = name + "  " + score;
		}
		return arrEasy;
	}
		
/** 
 * This function iterates through the moderate High Score array
 * and turns the score int into a string. It then creates
 * a new string consisting of the name and score with a space. 
 * @return returns an array of strings for display
 */
	public static String[] getModerateArray() {
		String[] arrMod = new String[size];
		
		for(int i = 0; i < size; i++) {
			String name = moderate[i].getName();
			String score = Integer.toString(moderate[i].getScore());
			arrMod[i] = name + "  " + score;
		}
		return arrMod;
	}
		
		
/** 
 * This function iterates through the moderate High Score array
 * and turns the score int into a string. It then creates
 * a new string consisting of the name and score with a space. 
 * @return returns an array of strings for display
 */
	public static String[] getHardArray() {
		String[] arrHard = new String[size];
		
		for(int i = 0; i < size; i++) {
			String name = hard[i].getName();
			String score = Integer.toString(hard[i].getScore());
			arrHard[i] = name + "  " + score;
		}
		return arrHard;
	}
		
		
/**
 * Constructor fills the arrays with blank scores at the start of 
 * the game
 */
	public HighScoreStorage() {
		
		HighScores blank = new HighScores(0, "---");
		
		for(int i = 0; i < size; i++) {
			easy[i] = blank;
			moderate[i] = blank;
			hard[i] = blank;
		}
		return;	
	}
		
/**
 * This function inserts a new High Score into an array. The new High
 * score is inserted into the proper position in the array. The score is 
 * checked with the lowest score in the array to ensure it is a high score.
 * Function is used in the isHighScore function.
 * @param arrayName - the array that will be updated with a new high score
 * @param newHigh - the new high score to be inserted
 */
	public static void insertHS(HighScores[] arrayName, HighScores newHigh) {
		
		int s = newHigh.getScore(); 
		int insertIndex = size-1; // set at last element in the array
		
		if(s <= arrayName[size-1].getScore()) {
			return;
		}
		
		else {
			for(int i = 0; i < size; i++) {
				// find location where the newHigh will be inserted
				if(s > arrayName[i].getScore()) {
					insertIndex = i;
					break;
				}
			}
			// starting at the last element of the array, move everything 
			// over by one until the point where the newHigh should 
			// be inserted
			for(int i = size-1; i > insertIndex; i--) {
				arrayName[i] = arrayName[i-1];
			}
			// insert the newHigh
			arrayName[insertIndex] = newHigh;
			
			try {
				System.out.print("saved ");
				HighScoreStorage.saveToComp();
			}
			catch(IOException e) {
				return;
			}
			return;
		}
	}
		
/**
 * This function saves the high score arrays to a text file
 * on the computer so the scores are not lost when the game is
 * exited.
 * @throws IOException
 */
	public static void saveToComp() throws IOException {
		
		PrintWriter writer = new PrintWriter("SimonScores.txt", "UTF-8");
		
		// go through each of the high score arrays and get the name and
		// score, changing the score to a string; write the info to the
		// text file
		for(int i = 0; i < size; i++) {
			String name = HighScoreStorage.easy[i].getName();
			String score = Integer.toString(HighScoreStorage.easy[i].getScore());
			writer.print(name + ":" + score + " ");
		}
		
		for(int i = 0; i < size; i++) {
			String name = HighScoreStorage.moderate[i].getName();
			String score = Integer.toString(HighScoreStorage.moderate[i].getScore());
			writer.print(name + ":" + score + " ");
		}
		
		for(int i = 0; i < size; i++) {
			String name = HighScoreStorage.hard[i].getName();
			String score = Integer.toString(HighScoreStorage.hard[i].getScore());
			writer.print(name + ":" + score + " ");
		}
		
		writer.close();
	}
		
/**
 * This function retrieves the high score informatio from the 
 * text file; that information is then used to update the high
 * score arrays with the saved scores
 */
	public void getCompScores() {
		
		String text = "";
		try {
			// retrieve the info from the text file as a string
			text = new String(Files.readAllBytes(Paths.get("SimonScores.txt")));
			
			int size = HighScoreStorage.size;
			
			// three temporary arrays to separate the info from the
			// text string into - easy(e), moderate(m), hard(h)
			String[] e = new String[size];
			String[] m = new String[size];
			String[] h = new String[size];

			// split the text string at each space, making substrings; 
			// put the substrings into a new array
	        String[] arrOfStr = text.split(" "); 
	        
	        // the first elements in the arrOfStr are the easy scores, second set
	        // are the moderate, and third set are the hard
	        for(int i = 0; i < size; i++) {
	        	e[i] = arrOfStr[i];
	        }
	        
	        for(int i = 0; i < size; i++) {
	        	m[i] = arrOfStr[i+size];
	        }
	        
	        for(int i = 0; i < size; i++) {
	        	h[i] = arrOfStr[i+(size*2)];
	        }
	        
	        // make a temp string and set it to the substring in the element
	        // being iterated on; next split the temp string into two substrings
	        // at the colon; set the two substrings to new variables; turn the 
	        // score substring into an int; make a new high scores object 
	        // with the score and name; put the object into the high scores storage
	        // array
	        for(int i = 0; i < size; i++) {
	        	String temp = e[i];
	        	String [] arrOfTemp = temp.split(":");
	        	String name = arrOfTemp[0];
	        	String scoreStr = arrOfTemp[1];
	        	int score = Integer.parseInt(scoreStr);
	        
	        	HighScores x = new HighScores(score, name);
	        	HighScoreStorage.easy[i] = x;
	        }
	        
	        for(int i = 0; i < size; i++) {
	        	String temp = m[i];
	        	String [] arrOfTemp = temp.split(":");
	        	String name = arrOfTemp[0];
	        	String scoreStr = arrOfTemp[1];
	        	int score = Integer.parseInt(scoreStr);
	        	
	        	HighScores x = new HighScores(score, name);
	        	HighScoreStorage.moderate[i] = x;
	        }
	        
	        for(int i = 0; i < size; i++) {
	        	String temp = h[i];
	        	String [] arrOfTemp = temp.split(":");
	        	String name = arrOfTemp[0];
	        	String scoreStr = arrOfTemp[1];
	        	int score = Integer.parseInt(scoreStr);
	        	
	        	HighScores x = new HighScores(score, name);
	        	HighScoreStorage.hard[i] = x;
	        }
		}
		// the very first time the game is played, the text file does not
		// exist; the function will return; the text file will be made upon
		// completion of playing the game the first time
		catch (IOException e) {
			return;
		}
	}
		
/**
 * This function contains a switch case that uses the int difLevel to select
 * the right High Score array for comparing score, and incerting scores onto the 
 * high score list
 * 
 * @param difLevel
 * @param score
 */
	static public void selectArray(int difLevel, int score) {
		switch(difLevel) {
		case 1:
			ScoreController.isHighScore(HighScoreStorage.easy, score);
			break;
		case 2:
			ScoreController.isHighScore(HighScoreStorage.moderate, score);
			break;
		case 3:
			ScoreController.isHighScore(HighScoreStorage.hard, score);
			break;
		}
	}
}

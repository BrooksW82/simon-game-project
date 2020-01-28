package Model;

/**
 * The class HighScores is used as multiple objects to hold each high score player 
 * and their score. It also has functions within the class to get the name and score
 * values it contains.
 */
public class HighScores {
	
	int score;
	String name; 
	
	// object that holds the name and score of a 
	// high scorer
	public HighScores(int s, String n){
		score = s;
		name = n;
	}
	
	public int getScore() {
		return score;
	}
	
	public String getName() {
		return name;
	}
}
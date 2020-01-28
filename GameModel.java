package Model;

import Model.ColorPattern;

public class GameModel{

    public static int counter;
    public static boolean c;
  
/**
 * Returns a boolean that indicates if the users color selection for a specific section
 * of the sequence they are attempting to repeat matches the original color sequence.    
 * @param pressed	an int that represents the users selected color.
 * @return			true if the selection is correct, false if otherwise.
 */
	static public boolean checkColor(int pressed) {
		if(pressed == ColorPattern.colorSequence[counter]) {
			c = true;
			counter++;
		}
		else {
			c = false;
		}
		return c;
	} 
}
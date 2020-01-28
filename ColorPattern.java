package Model;

import java.util.Random;
/**
 * Creates an array of randomly generated int (1-4), where
 * each int corresponds to a color. This array is to be generated
 * at the start of each new game of Simon.
 * 
 * {@colorSequence[]} is a public array that holds the created sequence of color used
 * by the GameRunnable class to display the colors, and check for correct user input. 
 */
public class ColorPattern {
	public static int colorSequence[];
	private static int min = 1;
	private static int max = 4;
	
/**
 * is the function called by the GameRunable class at the start of each game to
 * generate the color sequence that will be used for that game.	
 */
	public static void generateNewSeq() {
		colorSequence = new int[100];
		int i;
		for(i = 0; i < colorSequence.length; i++) {
			Random r = new Random();
			int color = r.nextInt((max-min) + 1 ) + min;
			colorSequence[i] = color;
		}
	}
}
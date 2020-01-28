package Controller;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import Model.Hard;
import Model.Moderate;
import Model.Easy;
import View.SimonShape;
import Model.Sound;
import Model.HighScoreStorage;
import Model.GameModel;
import View.DrawingPanel;
import Model.ColorPattern;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 * GameRunnable is the controller class for the game Simon. It controls the
 * flow of each game by; Getting initial parameters for the level of difficulty.
 * Dictating the amount of a color sequence to display, when to display them, 
 * and how quickly to display them. Receive user input and check it against 
 * colorSequence for correctness, as well as check user timeliness. Keep track of 
 * the current games score. Decided when and what note to play during each game.
 * And to determine when a game is over.
 */
public class GameRunnable implements Runnable, MouseListener {
   
    //the boolean value to tell when the game is running
    private volatile boolean running;
    private DrawingPanel drawingPanel; 
    static private int score; // current score
    static public int difLevel; //the level of difficulty
    int sleepNum = 0;
    static public int dispTime; //how fast the sequence is displayed
    int timePressed = 30; 
    int numToRead = 1; //number of colors per sequence segment
    public static long timeAllowed; //how fast the user needs to enter the sequence
    public static int initSeg; //the initial number of colors in the first round of the game
    int n; //represents the current round of game play
    int pressed;
    int readCount; //the number of color to be read from colorSequence
    int remain; //how many colors remain for the user to input
    private CountDownLatch doneSignal;

    public GameRunnable(DrawingPanel drawingPanel) {
        this.drawingPanel = drawingPanel;
    }
    
/**
 * This function is called when a game starts. it receives and int that indicates the level of 
 * difficulty. It uses that int in a switch case to get the attributes for that levels difficulty
 * from their respective classes. Each case calls two function. One that gets the rate at which
 * the color sequence will be displayed, the other gets an int that dictates the time limit the
 * user has to select the correct color.
 * @param difLevel
 */
	void selectDifficulty(int difLevel) {
		switch(difLevel) {
		case 1:{//easy
			timeAllowed = Easy.getTimeBetween();
			dispTime = Easy.getSeqSpeed();
			initSeg = Easy.getInitSeg();
			break;
		}
		case 2:{//mod
			timeAllowed = Moderate.getTimeBetween();
			dispTime = Moderate.getSeqSpeed();
			initSeg = Moderate.getInitSeg();
			break;
		}
		case 3:{//hard
			timeAllowed = Hard.getTimeBetween();
			dispTime = Hard.getSeqSpeed();
			initSeg = Hard.getInitSeg();
			break;
		}
		}
	}

/**
 * The run function is the main control function for the game. It is called at the start of
 * each new game of Simon. It calls ColorPattern in order to generate the sequence used for
 * that game. A while loop keeps track if the game is still running, while its running
 * the loop sets a counter to 0 so that it knows to start at the beginning of colorSequence for reads
 * and input checks. The initial sequence is displayed and a for loop is started inside the
 * while loop. This for loop sets the bool c to false at the start of the loop, so that the user
 * make it true provided they enter the correct color, which is checked an updated in GameModel.
 * if true the for loop continues till all colors read to the user are input by the user correctly
 * and within the correct time frame. Once the for loop completes and running is still set to true
 * the game will restarts the while loop. If running is set to false at any time, the game will exit
 * the while loop and proceed to call gameOver.
 */
    @Override
    public void run() {
    	score = 0;
    	ColorPattern.generateNewSeq();
    	selectDifficulty(difLevel);
    	System.out.println("difLvel: " + difLevel);
    	System.out.println("timeAllowed: " + timeAllowed);
    	System.out.println("dispTime: " + dispTime);
    	n = 1;
        running = true;
        
        while (running){
        	GameModel.counter = 0;
            dispSequence(numToRead, n);
            remain = readCount;
            SimonShape.frame.setTitle("Player Score: " + score + "     Colors Remaining: " + remain);
            for(int i = 0; i < readCount; i++) {
            	GameModel.c = false;	
            	doneSignal = new CountDownLatch(1);
            	try {
            		doneSignal.await(timeAllowed, TimeUnit.MILLISECONDS);
            	}catch(InterruptedException e) {	}

            	if (GameModel.c == true) {
            		remain = remain -1;
            		SimonShape.frame.setTitle("Player Score: " + score + "     Colors Remaining: " + remain);
                }
            	else if(GameModel.c == false) {
                	running = false;
                	break;
            	}
            }
            n++;
         }
        gameOver(score);
    }
    
/**
 * This function is used to decide how much of the colorSequence[] array is displayed 
 * and then iterate through the array and display the sequence. The numToRead argument
 * must indicate how many elements are read based on each level of difficulty. The
 * argument n is an int that tells what round the user is currently on during the game.
 * n is used by multiplying it by numToRead, producing readCount. readCount will be
 * used to indicate the exact point to which the array should be read and displayed.
 *     
 * @param numToRead	an int stored in difficulty, used as a multiplier to determine the
 * 					number of colors to add each round.
 * @param n			an int that indicates which round the user is on.
 */
	void dispSequence(int numToRead, int n) {
		readCount = (initSeg + numToRead*n); 
		int i = 0;
		sleep(dispTime*4);
		while(i < readCount && readCount <= ColorPattern.colorSequence.length) {
			int x = ColorPattern.colorSequence[i] - 1;
			drawingPanel.brighterArcModelColor(x);
			selectNote(x, dispTime); 
			SimonShape.frame.setTitle("Player Score: " + score + "     Colors Remaining: " + (i+1));
            drawingPanel.darkerArcModelColor(x);
            i++;
            sleep(dispTime);
		}
	}
	
/**
 * calls play() from the sound class. This function is used by the program when
 * displaying the sequence to the user. It designates a specific note to each color
 * and calls the function that plays the note when that color is being displayed.
 * 
 * @param x			an int representing the color
 * @param playFor	an int that tells the sound how long to play.
 */
	void selectNote(int x, int playFor) {
		switch(x) {
		case 3:{
			Sound.play(67, playFor);
			break;
		}
		case 2:{
			Sound.play(72, playFor);
			break;
		}
		case 1:{
			Sound.play(76, playFor);
			break;
		}
		case 0:{
			Sound.play(79, playFor);
			break;
		}
		}
	}

    public static void sleep(long duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {}
    }

    public synchronized void setRunning(boolean running) {
        this.running = running;
    }
    
/**
 * This function tracks the location of mouse clicks across and x:y axis. This
 * is overlaid across the colorful sections of the game, that when clicked
 * gives the appearance of buttons. Each sector of the x:y grid corresponds to
 * a particular color. When that sector is clicked the Panel 'lights' up and
 * a note it played.
 */
    @Override
	public void mousePressed(MouseEvent e)
	{
        int x = e.getX(), y = e.getY();
		if (x > 50 && x < 205 && y > 75 && y < 229){
			drawingPanel.brighterArcModelColor(3);
            pressed = 3;
            Sound.play(67, timePressed);
            
            if (GameModel.checkColor(pressed+1) == true) {score++;}
		 }//top right triangle
        if(x > 210 && x < 375 && y > 75 && y < 229){
        	drawingPanel.brighterArcModelColor(2);
        	pressed = 2;
            Sound.play(72, timePressed);
            
            if (GameModel.checkColor(pressed+1) == true) {score++;}
            }
         //bottom right
        if(x > 210 && x < 375 && y > 231 && y < 380){
        	drawingPanel.brighterArcModelColor(1);
        	pressed = 1;
            Sound.play(76, timePressed);
            
            if (GameModel.checkColor(pressed+1) == true) {score++;}
            }
         //bottom left 
        if(x > 50 && x < 205 && y > 231 && y < 380){
        	drawingPanel.brighterArcModelColor(0);
        	pressed = 0;
            Sound.play(79, timePressed);
            
            if (GameModel.checkColor(pressed+1) == true) {score++;}
            }
	}
    
/**
 * This function is called when the game is over, either when the user selects
 * the wrong color, or when the user takes to long to select a color. It receives 
 * the current score at the time the game is over. That score is used to call a
 * separate function to determine if its a new high score.
 *     
 * @param score	an int that holds the users score.
 */
    private void gameOver(int score) {
    	HighScoreStorage.selectArray(difLevel, score); ///not quite working.
    }

	@Override
	public void mouseClicked(MouseEvent e)
	{
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
      drawingPanel.darkerArcModelColor(0);
      drawingPanel.darkerArcModelColor(1);
      drawingPanel.darkerArcModelColor(2);
      drawingPanel.darkerArcModelColor(3);
      
      doneSignal.countDown();
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
	}
}
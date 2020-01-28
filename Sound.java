package Model;

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

/**
 * This class contains the code that creates and plays the sounds used
 * in the game. It does not store any sound files, but creates them using 
 * the sound.midi library. 
 */
public class Sound{
/**
 * Plays a sound when called. The note and duration of the sound played
 * will depend on the arguments received when this function is called. 
 * 
 * @param note		an int used to select what note will be played.
 * @param sleepNum	an int used to indicate how long a sound will be played.
 */
	public static void play(int note, int sleepNum) {
	      try{
	          Synthesizer midiSynth = MidiSystem.getSynthesizer(); 
	          midiSynth.open();

	          Instrument[] instr = midiSynth.getDefaultSoundbank().getInstruments();
	          MidiChannel[] mChannels = midiSynth.getChannels();
	          

	          midiSynth.loadInstrument(instr[0]);

	          MidiChannel channel = midiSynth.getChannels()[0];
	          channel.programChange(79);//can change instrument here!!!!!!
	          channel.setChannelPressure(-1);

	          mChannels[0].noteOn(note, 100);
	          try { Thread.sleep(sleepNum);
	          } catch( InterruptedException e ) { }
	          mChannels[0].noteOff(note);


	        } catch (MidiUnavailableException e) {}
	}
}
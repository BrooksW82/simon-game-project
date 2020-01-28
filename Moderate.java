package Model;

public class Moderate extends Difficulty{

	static public long getTimeBetween() {
		timeBetween = 750L;
		return timeBetween;
	}
	
	static public int getSeqSpeed() {
		seqSpeed = 350;
		return seqSpeed;
	}
	
	static public int getInitSeg() {
		initSeg = 2;
		return initSeg;
	}
}
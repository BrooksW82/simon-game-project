package Model;

public class Hard extends Difficulty{
	
	static public long getTimeBetween() {
		timeBetween = 600L;
		return timeBetween;
	}
	
	static public int getSeqSpeed() {
		seqSpeed = 250;
		return seqSpeed;
	}
	
	static public int getInitSeg() {
		initSeg = 3;
		return initSeg;
	}
}
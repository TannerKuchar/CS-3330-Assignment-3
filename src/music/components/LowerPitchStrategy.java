package music.components;

public class LowerPitchStrategy implements PitchStrategy {

	@Override
	public int modifyPitch(int note) {
		return note - 2;
	}

}

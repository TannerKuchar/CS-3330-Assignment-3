package music.components;

import javax.sound.midi.*;

public interface InstrumentStrategy {
	void applyInstrument(Track track, int channel);
}

package music.components;

import javax.sound.midi.*;

public class AcousticGrandPianoStrategy implements InstrumentStrategy {

	@Override
	public void applyInstrument(Track track, int channel)  {
		try {
			ShortMessage message = new ShortMessage(ShortMessage.PROGRAM_CHANGE, channel, 0, 0);
			track.add(new MidiEvent(message, 0));
		} catch (InvalidMidiDataException e) {
			System.out.println("Exception occurred: " + e);
		}
	}
	
}

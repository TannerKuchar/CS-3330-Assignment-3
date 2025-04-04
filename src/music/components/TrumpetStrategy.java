package music.components;

import javax.sound.midi.*;

public class TrumpetStrategy implements InstrumentStrategy {

	/**
	 * This method changes the instrument of a given track & channel to a trumpet.
	 * @param track
	 * @param channel
	 */
	@Override
	public void applyInstrument(Track track, int channel)  {
		try {
			ShortMessage message = new ShortMessage(ShortMessage.PROGRAM_CHANGE, channel, 56, 0);
			track.add(new MidiEvent(message, 0));
		} catch (InvalidMidiDataException e) {
			System.out.println("Exception occurred: " + e);
		}
	}
	
}

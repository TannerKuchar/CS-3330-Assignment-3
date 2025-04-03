package midi.factory;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;

public class StandardMidiEventFactory implements MidiEventFactory {

	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		try {
			throw new InvalidMidiDataException();
		} catch (InvalidMidiDataException e) {
			
		}
		return null;
	}

	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		try {
			throw new InvalidMidiDataException();
		} catch (InvalidMidiDataException e) {
			
		}
		return null;
	}

}

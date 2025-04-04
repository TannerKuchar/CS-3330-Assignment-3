package midi.factory;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

public class LegatoMidiEventFactory implements MidiEventFactory {

	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		try {
			ShortMessage newMessage = new ShortMessage();
			newMessage.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
			MidiEvent newEvent = new MidiEvent(newMessage, tick);
			return newEvent;
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		try {
			ShortMessage newMessage = new ShortMessage();
			newMessage.setMessage(ShortMessage.NOTE_OFF, channel, note, 0);
			tick = tick + 80; // Add 80 ticks to increase the duration
			MidiEvent newEvent = new MidiEvent(newMessage, tick);
			return newEvent;
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
		return null;
	}

}

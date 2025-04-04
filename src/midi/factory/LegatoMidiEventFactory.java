package midi.factory;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

public class LegatoMidiEventFactory implements MidiEventFactory {
	/**
	 * This method is used to create a MidiEvent in which a note is turning on.
	 * Given valid parameters, a MIDI event will be created at the given tick stamp.
	 * @param tick
	 * @param note
	 * @param velocity
	 * @param channel
	 */
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
	
	/**
	 * This method is used to create  MidiEvent in which a note is turning off.
	 * Given valid parameters, a MIDI event will be created 80 ticks after the given tick stamp.
	 * The 80 ticks are added to the given timestamp to achieve the "legato" effect.
	 * @param tick
	 * @param note
	 * @param channel
	 */
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

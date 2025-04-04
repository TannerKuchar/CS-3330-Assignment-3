package midi.data;

public class MidiEventData {
	private int startEndTick, velocity, note, channel, noteOnOff;
	private int instrument;
	
	/**
	 * Main constructor for MidiEventData. This class is used by the CSV parser and for
	 * users to easily create their own MIDI event.
	 * @param startEndTick
	 * @param velocity
	 * @param note
	 * @param channel
	 * @param instrument
	 * @param noteOnOff
	 */
	public MidiEventData(int startEndTick, int velocity, int note, int channel, int instrument, int noteOnOff) {
		this.startEndTick = startEndTick;
		this.velocity = velocity;
		this.note = note;
		this.channel = channel;
		this.instrument = instrument;
		this.noteOnOff = noteOnOff;
	}
	
	
	/**
	 * This method is used to convert information about this object into String form.
	 * Primarily used for troubleshooting.
	 */
	public String toString() {
		return "MIDI_EVENT_DATE: [tick = " + this.startEndTick + "] [velocity = " + this.velocity + "] [note = " + this.note + "] [channel = " + this.channel + "] [instrument = " + this.instrument + "] [onOff = " + noteOnOff + "]";
	}
	
	/* Generated getters & setters */

	public int getStartEndTick() {
		return startEndTick;
	}

	public void setStartEndTick(int startEndTick) {
		this.startEndTick = startEndTick;
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public int getNoteOnOff() {
		return noteOnOff;
	}

	public void setNoteOnOff(int noteOnOff) {
		this.noteOnOff = noteOnOff;
	}

	public int getInstrument() {
		return instrument;
	}

	public void setInstrument(int instrument) {
		this.instrument = instrument;
	}
	
	
}

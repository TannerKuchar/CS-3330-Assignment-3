package main;

/* Import Java Utilities */
import java.util.List;
import java.util.ArrayList;

/* Import CSV Utilities */
import csv.parser.MidiCsvParser;

import javax.sound.midi.MidiSystem;

/* Import Javax Sound Utilities */
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

/* Import MIDI Utilities */
import midi.data.*;
import midi.factory.*;
import midi.factory.MidiEventFactory;
import midi.factory.MidiEventFactoryAbstract;
import midi.factory.StandardMidiEventFactoryAbstract;
import music.components.*;

/**
 * Main script for the program. Parsing Billie Eilish CSV for testing.
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		try {
			
			// bad guy by Billie Eilish
			// Parsing through the CSV file
			List<MidiEventData> midiEvents = MidiCsvParser.parseCsv("src/csv/parser/mystery_song.csv");
			
			// Initializing a sequence
			Sequence sequence = new Sequence(Sequence.PPQ, 384);
			Track track = sequence.createTrack();
			
			// Creating the abstract factory
			MidiEventFactoryAbstract factoryAbstract = new LegatoMidiEventFactoryAbstract();
			
			// Creating the factory to build MidiEvents from
			MidiEventFactory factory = factoryAbstract.createFactory();
			
			// Implementing a pitch strategy
			PitchStrategy pitchStrategy = new HigherPitchStrategy();
			
			// Implementing an instrument strategy
			InstrumentStrategy instrumentStrategy = new TrumpetStrategy();
			instrumentStrategy.applyInstrument(track, 0);
			
			// After parsing through the CSV file, convert the MidiEventData classes into MidiEvents. 
			for (MidiEventData event: midiEvents) { // For each event in midi events
				int modifiedNote = pitchStrategy.modifyPitch(event.getNote()); // Apply pitch strategy
				if (event.getNoteOnOff() == 1) { // If the note is turning on
					track.add(factory.createNoteOn(event.getStartEndTick(), modifiedNote, event.getVelocity(), event.getChannel()));
				} else {
					track.add(factory.createNoteOff(event.getStartEndTick(), modifiedNote, event.getChannel()));
				}
			}
			
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.setSequence(sequence);
			sequencer.start();
			
			// Close the sequencer when complete
			while (sequencer.isRunning() | sequencer.isOpen()) {
				Thread.sleep(500);
			}
			Thread.sleep(500);
			sequencer.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
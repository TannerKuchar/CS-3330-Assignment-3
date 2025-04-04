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
import midi.factory.MidiEventFactory;
import midi.factory.MidiEventFactoryAbstract;
import midi.factory.StandardMidiEventFactoryAbstract;
import music.components.*;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			List<MidiEventData> midiEvents = MidiCsvParser.parseCsvFile("src/csv/parser/mystery_song.csv");
			Sequence sequence = new Sequence(Sequence.PPQ, 384);
			Track track = sequence.createTrack();
			
			System.out.println("Got to line 35");
			
			MidiEventFactoryAbstract factoryAbstract = new StandardMidiEventFactoryAbstract();
			
			MidiEventFactory factory = factoryAbstract.createFactory();
			
			InstrumentStrategy instrumentStrategy = new ElectricBassGuitarStrategy();
			instrumentStrategy.applyInstrument(track, 0);
			
			instrumentStrategy = new TrumpetStrategy();
			instrumentStrategy.applyInstrument(track,  1);
			
			System.out.println("Got to line 47");
			
			PitchStrategy pitchStrategy = new HigherPitchStrategy();
			
			for (MidiEventData event: midiEvents) { // For each event in midi events
				System.out.println("Adding midi event data");
				int modifiedNote = pitchStrategy.modifyPitch(event.getNote());
				modifiedNote = pitchStrategy.modifyPitch(modifiedNote);
				
				if (event.getNoteOnOff() == ShortMessage.NOTE_ON) {
					track.add(factory.createNoteOn(event.getStartEndTick(), modifiedNote, event.getVelocity(), event.getChannel()));
				} else {
					track.add(factory.createNoteOff(event.getStartEndTick(), modifiedNote, event.getChannel()));
				}
			}
			
			System.out.println("Completed adding midi events");
			
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.setSequence(sequence);
			sequencer.start();
			
			System.out.println("Sequencer has started");
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

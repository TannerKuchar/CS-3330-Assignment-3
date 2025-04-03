package csv.parser;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import midi.data.MidiEventData;

public class Tester {

	public static void main(String[] args) {
		
		System.out.println("Running code");	// TODO Auto-generated method stub
		String filepath = "src/csv/parser/mystery_song.csv";
		List<MidiEventData> events = MidiCsvParser.parseCsvFile(filepath);
		
		System.out.println(events.get(0).getNoteOnOff());
	}

}

package csv.parser;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* Import Midi Data Type */
import midi.data.MidiEventData;

public class MidiCsvParser {
	
	public static List<MidiEventData> parseCsv(String filepath) {
		
		// Initialize array to store each event in
		List<MidiEventData> events = new ArrayList();
		
		/* Important to implement error handling when dealing with user input such as reading a user's file */
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath))) {
			String currentLine = bufferedReader.readLine();
			while (currentLine != null) {
				String[] values = currentLine.split(","); // Splits the line by comma
				
				// Getting rid of whitespace just in case
				for (int i = 0; i < values.length; i ++) {
					values[i] = values[i].trim();
				}
				
				// Getting all of the values from the parsed line
				int startEndTick = Integer.parseInt(values[0]);
				int noteOnOff = values[1].equals("Note_on_c") ? 1:0; // Derek's JavaScript brain working
				int channel = Integer.parseInt(values[2]);
				int note = Integer.parseInt(values[3]);
				int velocity = Integer.parseInt(values[4]);
				int instrument = Integer.parseInt(values[5]);
				
				// Adding the event to the events list
				MidiEventData newEvent = new MidiEventData(startEndTick, velocity, note, channel, instrument, noteOnOff);
				events.add(newEvent);
				
				currentLine = bufferedReader.readLine();
			}
		
		return events;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}

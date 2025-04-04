package midi.factory;

public class StandardMidiEventFactoryAbstract implements MidiEventFactoryAbstract {

	@Override
	public MidiEventFactory createFactory() {
		MidiEventFactory factory = new StandardMidiEventFactory();
		return factory;
	}

}

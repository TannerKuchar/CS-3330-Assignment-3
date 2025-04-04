package midi.factory;

public class LegatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract {

	@Override
	public MidiEventFactory createFactory() {
		MidiEventFactory factory = new LegatoMidiEventFactory();
		return factory;
	}

}

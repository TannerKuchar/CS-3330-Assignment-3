package midi.factory;

public class StandardMidiEventFactoryAbstract implements MidiEventFactoryAbstract {

	@Override
	public MidiEventFactory createFactory() {
		MidiEventFactoryAbstract factoryAbstract = null;
		factoryAbstract = new StandardMidiEventFactoryAbstract();
		MidiEventFactory factory = factoryAbstract.createFactory();
		return factory;
	}

}

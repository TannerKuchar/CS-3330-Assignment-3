package midi.factory;

public class LegatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract {

	@Override
	public MidiEventFactory createFactory() {
		MidiEventFactoryAbstract factoryAbstract = null;
		factoryAbstract = new LegatoMidiEventFactoryAbstract();
		MidiEventFactory factory = factoryAbstract.createFactory();
		return factory;
	}

}

package midi.factory;

public class StaccatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract {

	@Override
	public MidiEventFactory createFactory() {
		MidiEventFactoryAbstract factoryAbstract = null;
		factoryAbstract = new StaccatoMidiEventFactoryAbstract();
		MidiEventFactory factory = factoryAbstract.createFactory();
		return factory;
	}

}

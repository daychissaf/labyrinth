public class ParserImpl implements Parser {
    private static ParserImpl instance;

    private ParserImpl() {
    }

    public static ParserImpl getParser() {
        if (instance == null) {
            instance = new ParserImpl();
        }
        return instance;
    }

    public Gate parseGate(String gate) {
        return Gate.initGate(gate.charAt(INDEX_OF_START_ROOM), gate.charAt(INDEX_OF_END_ROOM), gate.charAt(INDEX_OF_GATE_TYPE));
    }
}

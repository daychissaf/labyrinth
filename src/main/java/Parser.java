public interface Parser {
    int INDEX_OF_START_ROOM = 0;
    int INDEX_OF_END_ROOM = 2;
    int INDEX_OF_GATE_TYPE = 1;
    int OPEN_GATE = 1;
    int CLOSE_GATE = 0;
    int ILLEGAL_MOVE = 1;
    int CLOSED_DOOR = 2;
    int LEGAL_MOVE = 0;
    char GATE_WITH_SENSOR_ON = '$';

    Gate parseGate(String gate);
}

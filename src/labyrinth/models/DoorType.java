package labyrinth.models;

public class DoorType {
    private static final char UNMONITORES = '|', MONITORED = '$';
    private char doorTypeSymbol;
    private DoorState doorState;

    public DoorType(char doorTypeSymbol) {
        this.doorTypeSymbol = doorTypeSymbol;
        doorState = DoorState.OPEN;
    }

    public boolean isOpen() {
        return doorState == DoorState.OPEN;
    }

    public void close() {
        doorState = DoorState.CLOSE;
    }

    public boolean isMonitored() {
        return doorTypeSymbol==MONITORED;
    }
}


import java.util.ArrayList;
import java.util.List;

public class Labyrinth {
    private static final ParserImpl gateParser = ParserImpl.getParser();
    private List<Gate> listOfGate;
    private String currentRoom;
    private Gate lastGate;
    private String sensorsRoad;

    public Labyrinth(String... gates) {
        listOfGate = new ArrayList<Gate>();
        this.sensorsRoad = "";
        this.addGates(gates);
    }

    private void addGates(String... gates) {
        for (int iterator = 0; iterator < gates.length; iterator++) {
            this.listOfGate.add(gateParser.parseGate(gates[iterator]));
        }
    }

    public void popIn(String room) {
        this.currentRoom = room;
    }

    public void walkTo(String room) throws IllegalMoveException, ClosedDoorException {
        for (int iterator = 0; iterator < this.listOfGate.size(); iterator++) {
            int responseOfVerifyGate = this.listOfGate.get(iterator).verifyGate(this.currentRoom, room);
            if (responseOfVerifyGate == Parser.LEGAL_MOVE) {
                setCurrentRoom(room, iterator);
                return;
            } else if (responseOfVerifyGate == Parser.CLOSED_DOOR) {
                throw new ClosedDoorException();
            }
        }
        throw new IllegalMoveException();
    }

    private void setCurrentRoom(String room, int indexOfGate) {
        if (this.listOfGate.get(indexOfGate).isSensorsGate()) {
            this.addToSensorsRoad(room);
        }
        this.currentRoom = room;
        this.lastGate = this.listOfGate.get(indexOfGate);
    }

    public void closeLastDoor() throws DoorAlreadyClosedException {
        this.lastGate.closeGate();
    }

    public String readSensors() {
        return this.sensorsRoad;
    }

    private void addToSensorsRoad(String room) {
        if (!this.sensorsRoad.equals("")) {
            this.sensorsRoad += ";";
        }
        this.sensorsRoad += this.currentRoom + "" + room;
    }
}
public class Gate {
    private char startRoom;
    private char endRoom;
    private char gateType;
    private int statutOfGate;

    private Gate(char startRoom, char endRoom, char gateType) {
        this.startRoom = startRoom;
        this.endRoom = endRoom;
        this.gateType = gateType;
        this.statutOfGate = Parser.OPEN_GATE;
    }

    public static Gate initGate(char startRoom, char endRoom, char gateType) {
        return new Gate(startRoom, endRoom, gateType);
    }

    public int verifyGate(String startRoom, String endRoom) {
        if (this.equals(startRoom, endRoom)) {
            if (isOpenGate()) {
                return Parser.LEGAL_MOVE;
            } else {
                return Parser.CLOSED_DOOR;
            }
        }
        return Parser.ILLEGAL_MOVE;
    }

    public boolean isOpenGate() {
        return this.statutOfGate == Parser.OPEN_GATE;
    }

    public boolean equals(String startRoom, String endRoom) {
        return ((this.startRoom == startRoom.charAt(0) && this.endRoom == endRoom.charAt(0)) || (this.startRoom == endRoom.charAt(0) && this.endRoom == startRoom.charAt(0)));
    }

    public void closeGate() throws DoorAlreadyClosedException {
        if (isOpenGate()) {
            this.statutOfGate = Parser.CLOSE_GATE;
        }
        throw new DoorAlreadyClosedException();
    }

    public boolean isSensorsGate() {
        return this.gateType == Parser.GATE_WITH_SENSOR_ON;
    }
}

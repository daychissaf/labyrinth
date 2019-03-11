import java.util.*;

public class Labyrinth {
    private String[] labyrinthContent;
    private Room startingRoom;
    private Room currentRoom;
    private Room previousRoom;
    private List<Room> labyrinthRooms;
    private List<Gate> labyrinthGates;
    private String labyrinthsensors = "";

    public Labyrinth(String... labyrinthContent) {
        this.labyrinthContent = labyrinthContent;
        labyrinthRooms = new ArrayList<Room>();
        labyrinthGates = new ArrayList<Gate>();
        labyrinthFactory();
    }

    public void popIn(String roomName) {
        this.startingRoom = getRoomByName(roomName);
        this.currentRoom = getRoomByName(roomName);
    }

    public void walkTo(String destinationRoom) throws IllegalMoveException, ClosedDoorException {
        if (canWalkTo(getRoomByName(destinationRoom))) {
            this.previousRoom = this.currentRoom;
            this.currentRoom = getRoomByName(destinationRoom);
        } else {
            throw new IllegalMoveException();
        }
    }

    public Room getRoomByName(String roomName) {
        for (Room roomIndex : labyrinthRooms) {
            if (roomIndex.getRoomName().equals(roomName)) {
                return roomIndex;
            }
        }
        return null;
    }

    public boolean canWalkTo(Room destinationRoom) throws ClosedDoorException {
        for (Gate gateIndex : currentRoom.getGates()) {
            if (gateIndex.getDestinationRoom().equals(destinationRoom) || gateIndex.getOriginRoom().equals(destinationRoom)) {
                if (!gateIndex.isOpen()) {
                    throw new ClosedDoorException();
                }
                return true;
            }
        }
        return false;
    }

    public boolean hasRoom(Room newRoom) {
        for (Room roomIndex : labyrinthRooms) {
            if (roomIndex.getRoomName().equals(newRoom.getRoomName())) {
                return true;
            }
        }
        return false;
    }

    public void labyrinthFactory() {
        for (String labyrinthElement : labyrinthContent) {
            Room newLeftRoom = roomFactory(String.valueOf(labyrinthElement.charAt(0)));
            Room newRightRoom = roomFactory(String.valueOf(labyrinthElement.charAt(2)));
            Gate newGate = new Gate(newLeftRoom, newRightRoom, String.valueOf(labyrinthElement.charAt(1)));
            newRightRoom.addGate(newGate);
            newLeftRoom.addGate(newGate);
            labyrinthGates.add(newGate);
        }
    }

    public Room roomFactory(String roomDescription) {
        Room newRoomFactory = new Room(roomDescription);
        if (hasRoom(newRoomFactory)) {
            newRoomFactory = getRoomByName(newRoomFactory.getRoomName());
        } else {
            labyrinthRooms.add(newRoomFactory);
        }
        return newRoomFactory;
    }

    public void closeLastDoor() throws DoorAlreadyClosedException {
        boolean doorClosed = true;
        for (Gate gateIndex : labyrinthGates) {
            if (gateIndex.isOpen() && gateIndex.getOriginRoom().equals(previousRoom) && gateIndex.getDestinationRoom().equals(currentRoom)) {
                doorClosed = false;
                gateIndex.closeDoor();
            }
        }
        if (doorClosed) {
            throw new DoorAlreadyClosedException();
        }
    }

    public String readSensors() {
        if (isSensorGate(currentRoom, previousRoom)) {
            if (this.labyrinthsensors.equals("")) {
                this.labyrinthsensors = this.labyrinthsensors + previousRoom.getRoomName() + currentRoom.getRoomName();
            } else {
                this.labyrinthsensors = this.labyrinthsensors + ";" + previousRoom.getRoomName() + currentRoom.getRoomName();
            }
        }
        return this.labyrinthsensors;
    }

    public boolean isSensorGate(Room destinationRoom, Room originRoom) {
        for (Gate gateIndex : labyrinthGates) {
            if (gateIndex.getOriginRoom().equals(originRoom) && gateIndex.getDestinationRoom().equals(destinationRoom) && gateIndex.isSensor()) {
                return true;
            }
        }
        return false;
    }
}

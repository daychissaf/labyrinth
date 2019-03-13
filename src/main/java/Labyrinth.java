import exceptions.ClosedDoorException;
import exceptions.IllegalMoveException;

import java.util.List;

public class Labyrinth {

    private List<RoomPair> roomPairs;
    private Walker walker;


    public Labyrinth(String... rooms) {

        this.walker = new Walker();
        this.roomPairs = RoomParser.createRooms(rooms);

    }

    public void popIn(String roomName) {
        if (walker.isRoomsEmpty()) {
            walker.popIn(getRoomPairFromRoomPairs(roomName));
        } else
            throw new IllegalMoveException("WalkTo a Room does not exist");

    }


    public RoomPair getRoomPairFromRoomPairs(String roomName) {
        for (RoomPair roomPair : roomPairs) {
            if (roomPair.isThisPreviousRoom(roomName))
                return roomPair;
        }
        throw new IllegalMoveException("Room Does not exist in Rooms");
    }


    public boolean walkForwardOrBackwardTo(String roomName) {

        for (RoomPair roomPair : roomPairs) {
            if (roomPair.isThisNextRoom(roomName) && walker.isWalkable(roomPair)){
                if(roomPair.isClosed())  throw new ClosedDoorException();
                return walker.walkTo(roomPair);
            }

            if (roomPair.isThisPreviousRoom(roomName) &&
                    walker.isWalkableBackward(roomPair)){
                if(roomPair.isClosed())  throw new ClosedDoorException();
                return walker.walkToBack(roomPair);
            }

        }
        return false;
    }


    public void walkTo(String roomName) {
        if (walker.isClosed())
            throw new ClosedDoorException("Door closed");
        if (!walkForwardOrBackwardTo(roomName))
            throw new IllegalMoveException("Can not reach Room " + roomName);

    }

    public void closeLastDoor() {
        for (RoomPair roomPair : roomPairs) {
            if (walker.isThisCurrentRoom(roomPair) ||
                    walker.isThisCurrentRoomReversed(roomPair)) {
                roomPair.closeDoor();
            }
        }

    }


    public String readSensors() {
        return walker.readWalkHistory() ;
    }

}

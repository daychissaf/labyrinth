import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Walker {


    private RoomPair roomPair;
    private List<RoomPair> walkHistory;


    public Walker() {
        roomPair = new RoomPair();
        walkHistory=new ArrayList<>();
    }


    public boolean isClosed() {

        return roomPair.isClosed();
    }

    public boolean isRoomsEmpty() {
        return roomPair.isPreviousRoomEmpty();
    }

    public void popIn(RoomPair roomPair) {

        this.roomPair.popIn(roomPair);
    }


    public boolean isThisCurrentRoom(RoomPair roomPair) {
        return this.roomPair.isThisPreviousRoom(roomPair);
    }

    public boolean isThisCurrentRoomReversed(RoomPair roomPair) {
        return this.roomPair.isThisRoomReversed(roomPair);
    }


    public boolean walkTo(RoomPair roomPair) {
        this.roomPair = roomPair.clone();
        walkHistory.add(this.roomPair);
        return true;
    }

    public boolean walkToBack(RoomPair roomPair) {

        this.roomPair.walkToBack(roomPair);
        return true;
    }



    public boolean isWalkable(RoomPair roomPair) {
        return this.roomPair.isWalkableTo(roomPair);

    }

    public boolean isWalkableBackward(RoomPair roomPair) {
        return this.roomPair.isWalkableBackwardTo(roomPair);


    }

    public String readWalkHistory() {
        StringJoiner joiner = new StringJoiner(";");

        for (RoomPair roomPair : walkHistory)
            if (roomPair.doorWithSensor())
                joiner.add(roomPair.print());

        return joiner.toString();
    }


}


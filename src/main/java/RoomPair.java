public class RoomPair {

    private Room previousRoom;

    private Room nextRoom;

    private Door door;

    public RoomPair() {
        this.previousRoom = new Room();
        this.nextRoom = new Room();
        this.door = new Door();

    }


    public RoomPair(RoomPair roomPair) {

        this.previousRoom = roomPair.previousRoom;
        this.nextRoom = roomPair.nextRoom;
        this.door = roomPair.door.clone();

    }

    public RoomPair clone() {
        return new RoomPair(this);
    }

    public RoomPair(Room previousRoom, Room nextRoom,DoorType doorType) {
        this.previousRoom = previousRoom;
        this.nextRoom = nextRoom;
        this.door = new Door(doorType);
    }

    public boolean isClosed() {
        return door.isClosed();
    }

    public boolean isPreviousRoomEmpty() {
        return previousRoom.isTheRoomEmpty();
    }

    public boolean isThisPreviousRoom(String roomName) {
        return previousRoom.isThisRoom(roomName);
    }

    public boolean isThisPreviousRoom(RoomPair roomPair) {
        return this.previousRoom.isThisRoom(roomPair.previousRoom);
    }

    public void closeDoor() {
        door.closeDoor();
    }

    public boolean isThisNextRoom(String roomName) {
        return nextRoom.isThisRoom(roomName);
    }

    @Override
    public String toString() {
        return "RoomPair{" +
                "previousRoom=" + previousRoom +
                ", nextRoom=" + nextRoom +
                ", door=" + door +
                '}';
    }

    public boolean isWalkableTo(RoomPair roomPair) {

        return this.nextRoom.isThisRoom(roomPair.previousRoom);
    }

    public void popIn(RoomPair roomPair) {
        this.nextRoom = roomPair.previousRoom;
        this.previousRoom = new Room();
    }

    public boolean isWalkableBackwardTo(RoomPair roomPair) {
        return this.nextRoom.isThisRoom(roomPair.nextRoom);
    }

    public void walkToBack(RoomPair roomPair) {
        Room temp = roomPair.previousRoom;
        this.previousRoom = roomPair.nextRoom;
        this.nextRoom = temp;
        this.door = roomPair.door.clone();
    }

    public boolean isThisRoomReversed(RoomPair roomPair) {

        return this.nextRoom.isThisRoom(roomPair.previousRoom) &&
                this.previousRoom.isThisRoom(roomPair.nextRoom);
    }

    public String print() {
        return previousRoom.print() + nextRoom.print() ;
    }

    public boolean doorWithSensor() {
        return door.withSensor();
    }
}

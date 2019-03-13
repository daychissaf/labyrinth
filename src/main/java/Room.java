public class Room {

    private String roomName;

    public Room(String roomName) {
        this.roomName = roomName;

    }

    public Room() {
        this.roomName = "";
    }


    public boolean isThisRoom(Room room) {
        return room.roomName.equalsIgnoreCase(this.roomName);
    }

    public boolean isThisRoom(String roomName) {
        return this.roomName.equalsIgnoreCase(roomName);
    }


    public boolean isTheRoomEmpty() {

        return this.roomName.equals("");
    }


    @Override
    public String toString() {
        return "Room{" +
                "roomName='" + roomName + '\'' +
                '}';
    }

    public String print() {
        return roomName;
    }
}

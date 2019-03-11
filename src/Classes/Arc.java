package Classes;

public class Arc {

    private Door door;
    private String originRoom;
    private String destinationRoom;


    public Arc(String originRoom, String destinationRoom, Door door) {
        this.originRoom = originRoom;
        this.destinationRoom = destinationRoom;
        this.door = door;
    }


    public String startAndDestinationRooms(){
        return originRoom+""+destinationRoom;
    }

    public boolean isStartRoom(String room){
        return originRoom.equals(room);
    }

    public boolean isDestinationRoom(String room){
        return destinationRoom.equals(room);
    }

    public boolean closeTheDoor(){
        return door.close();
    }

    public boolean canGoThroughTheDoor(){
        return door.doorState();
    }


    public Door.DoorType doorType(){
        return door.isFirstOrSecondDoorType();
    }

    @Override
    public String toString() {
        return originRoom+" - "+door+" -> "+originRoom;
    }
}

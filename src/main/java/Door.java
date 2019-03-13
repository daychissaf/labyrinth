import exceptions.DoorAlreadyClosedException;

public class Door {

    private DoorState state;

    private DoorType doorType;


    public Door() {
        state=DoorState.OPEN;
        doorType=DoorType.NONE;
    }

    public Door(DoorType doorType) {
        state=DoorState.OPEN;
        this.doorType = doorType;
    }

    public Door(Door door){
        this.state = door.state;
        this.doorType=door.doorType;
    }

    public boolean withSensor() {
        return doorType.equals(DoorType.WITH_SENSOR);
    }

    public Door clone(){

        return new Door(this);
    }


    public void closeDoor(){
        if(state.equals(DoorState.CLOSED))
            throw new DoorAlreadyClosedException("DoorAlreadyClosedException ! Door closed");
        state=DoorState.CLOSED;
    }

    public boolean isClosed(){
        return state.equals(DoorState.CLOSED);
    }

    @Override
    public String toString() {
        return "Door{" +
                "state=" + state +
                ", doorType=" + doorType +
                '}';
    }
}

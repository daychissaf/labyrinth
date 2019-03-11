package labyrinth;

public class Door {

    private DoorType doorType;
    private boolean stat;

    public Door(String doorType) {
        if(DoorType.FIRST_TYPE.toString().equals(doorType))
            this.doorType =DoorType.FIRST_TYPE;
        else
            this.doorType =DoorType.SECOND_TYPE;
        this.stat = true;
    }

    public boolean close() {
        if (stat) {
            stat = false;
            return true;
        } else return false;

    }

    public boolean doorStat(){
        return stat;
    }

    public DoorType isFirstOrSecondDoorType(){
        return doorType;
    }

    @Override
    public String toString() {
        return doorType.toString();
    }
}

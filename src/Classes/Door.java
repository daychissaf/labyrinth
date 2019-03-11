package Classes;

public class Door {

    private boolean doorState;
    private DoorType doorType;


    public Door(String doorType) {
        if(DoorType.FIRST_TYPE.toString().equals(doorType))
            this.doorType =DoorType.FIRST_TYPE;
        else
            this.doorType =DoorType.SECOND_TYPE;
        this.doorState = true;
    }

    public boolean close() {
        if (doorState) {
            doorState = false;
            return true;
        } else return false;

    }

    public boolean doorState(){
        return doorState;
    }

    public DoorType isFirstOrSecondDoorType(){
        return doorType;
    }

    @Override
    public String toString() {
        return doorType.toString();
    }



    public enum DoorType {

        FIRST_TYPE("$"), SECOND_TYPE("|");

        String symbol;
        boolean doorState;

        DoorType(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return symbol;
        }
    }

}

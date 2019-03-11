package CleanCode2.Labyrinth;

public class ClosedDoorException extends Exception {
    public ClosedDoorException(){
        super("Door is already Closed");
    }
}

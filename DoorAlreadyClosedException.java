package CleanCode2.Labyrinth;

public class DoorAlreadyClosedException extends Exception {
    public DoorAlreadyClosedException(){
        super("The door is already Closed");
    }
}

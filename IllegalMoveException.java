package CleanCode2.Labyrinth;

public class IllegalMoveException extends Exception {
    public IllegalMoveException(){
        super("You can't move this way");
    }
}

package Exceptions;

public class ClosedDoorException extends RuntimeException {
    public ClosedDoorException() {
        System.out.println("Warning ! The door is closed");
    }
}

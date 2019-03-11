package Exceptions;

public class DoorAlreadyClosedException extends RuntimeException {
    public DoorAlreadyClosedException() {
        System.out.println("Warning ! The door is already closed");
    }
}

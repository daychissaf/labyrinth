package Exceptions;

public class IllegalMoveException extends RuntimeException {
    public IllegalMoveException() {
        System.out.println("Warning ! You can't move this way");
    }
}

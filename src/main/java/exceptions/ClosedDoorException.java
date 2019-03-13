package exceptions;

public class ClosedDoorException extends RuntimeException {

    private static final long serialVersionUID = 1L;


    public ClosedDoorException() {
        super();
    }

    public ClosedDoorException(final String message, final Throwable cause) {
        super(message, cause);
    }


    public ClosedDoorException(final String message) {
        super(message);
    }


    public ClosedDoorException(final Throwable cause) {
        super(cause);
    }

}

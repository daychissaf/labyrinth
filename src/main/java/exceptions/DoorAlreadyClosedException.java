package exceptions;

public class DoorAlreadyClosedException extends RuntimeException
{

	private static final long serialVersionUID = 1L;


	public DoorAlreadyClosedException()
	{
		super();
	}


	public DoorAlreadyClosedException(final String message, final Throwable cause)
	{
		super(message, cause);
	}


	public DoorAlreadyClosedException(final String message)
	{
		super(message);
	}


	public DoorAlreadyClosedException(final Throwable cause)
	{
		super(cause);
	}

}

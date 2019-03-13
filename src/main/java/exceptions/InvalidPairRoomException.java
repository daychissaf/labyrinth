package exceptions;

public class InvalidPairRoomException extends RuntimeException
{

	private static final long serialVersionUID = 1L;


	public InvalidPairRoomException()
	{
		super();
	}


	public InvalidPairRoomException(final String message, final Throwable cause)
	{
		super(message, cause);
	}


	public InvalidPairRoomException(final String message)
	{
		super(message);
	}


	public InvalidPairRoomException(final Throwable cause)
	{
		super(cause);
	}

}

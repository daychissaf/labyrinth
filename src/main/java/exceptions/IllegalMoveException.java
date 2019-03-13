package exceptions;

public class IllegalMoveException extends RuntimeException
{

	private static final long serialVersionUID = 1L;

	public IllegalMoveException()
	{
		super();
	}


	public IllegalMoveException(final String message, final Throwable cause)
	{
		super(message, cause);
	}


	public IllegalMoveException(final String message)
	{
		super(message);
	}


	public IllegalMoveException(final Throwable cause)
	{
		super(cause);
	}

}

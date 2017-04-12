package week1;
// Fig. 20.8 EmptyStackException.java class declaration
public class EmptyStackException extends RuntimeException
{
	// no arguement constructor
	public EmptyStackException()
	{
		this("Stack is empty");
	}
	
	// one-arguement constructor
	public EmptyStackException(String message)
	{
		super(message);
	}
}
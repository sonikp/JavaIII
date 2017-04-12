package week1;
//fig 20.7 Stack generic class definition
import java.util.ArrayList;

public class Stack<T>
{
	private final ArrayList<T> elements;
	
	// no argument constructor creates a stack of the default size
	public Stack()
	{
		this(10);
	}
	
	// constructor creates a stack of the specified number of elements
	public Stack(int capacity)
	{
		int initCapacity = capacity > 0 ? capacity : 10; 	// validate
		elements = new ArrayList<T>(initCapacity);		// create ArrayList
	}
	
	// constructor creates a stack of the specified number of elements
	public void push(T pushValue)
	{
		elements.add(pushValue);	// place pushValue on Stack
	}
	
	// return the top element if not empty; else throw EmptyStackException
	public T pop()
	{
		if (elements.isEmpty())	// if stack is empty
		{
			throw new EmptyStackException("Stack is empty, cannot pop!!");
		}
		
		return elements.remove(elements.size() - 1);
	}

}

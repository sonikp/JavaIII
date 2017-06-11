package week7;
// fig 23.6

import java.lang.Runnable;

public class SimpleArrayWriter implements Runnable
{
	private final SimpleArray sharedSimpleArray;
	private final int startValue;
	
	public SimpleArrayWriter(int value, SimpleArray array)
	{
		startValue = value;
		sharedSimpleArray = array;
	}
	
	public void run()
	{
		for (int i = startValue; i < startValue + 3; i++)
		{
			sharedSimpleArray.add(i);	// adds element to the shared array
		}
	}
}

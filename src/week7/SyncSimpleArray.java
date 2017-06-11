package week7;
// fig 23.8

import java.security.SecureRandom;
import java.util.Arrays;

public class SyncSimpleArray	// Thread safe with 'synchronized' keyword
{
	private static final SecureRandom generator = new SecureRandom();
	private final int array[];
	private int writeIndex = 0;
	
	// construct a SimpleArray of a given size
	public SyncSimpleArray(int size)
	{
		array = new int[size];
	}
	
	// add a value to the shared array
	public synchronized void add(int value)
	{
		int position = writeIndex;	// store the write index
		
		try
		{
			// in real application, you shouldn't sleep while holding a lock
			Thread.sleep(generator.nextInt(500));
		}
		catch (InterruptedException ex)
		{
			ex.printStackTrace();
		}
		
		// put value in the appropriate element
		array[position] = value;
		System.out.printf("%s wrote %2d to element %d.%n", Thread.currentThread().getName(), value, position);
		
		++writeIndex;
		System.out.printf("Next write index: %d%n", writeIndex);
	}
	
	// used for outputting the contents o the shared integer array
	public synchronized String toString()
	{
		return Arrays.toString(array);
	}
}















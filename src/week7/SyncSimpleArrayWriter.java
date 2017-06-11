package week7;
// fig 23.6 // same as other file only now uses synchronized simple array

import java.lang.Runnable;

public class SyncSimpleArrayWriter implements Runnable
{
	private final SyncSimpleArray sharedSyncSimpleArray;
	private final int startValue;
	
	public SyncSimpleArrayWriter(int value, SyncSimpleArray array)
	{
		startValue = value;
		sharedSyncSimpleArray = array;
	}
	
	public void run()
	{
		for (int i = startValue; i < startValue + 3; i++)
		{
			sharedSyncSimpleArray.add(i);	// adds element to the shared array
		}
	}
}

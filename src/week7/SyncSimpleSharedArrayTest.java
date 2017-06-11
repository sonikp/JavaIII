package week7;
// fig 23.7 // same as other file only now uses synchronized simple array

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;

public class SyncSimpleSharedArrayTest
{
	public static void main(String[] args)
	{
		// construct the shared object
		SyncSimpleArray sharedSyncSimpleArray = new SyncSimpleArray(6);
		
		// create two tasks to write to the shared SimpleArray
		SyncSimpleArrayWriter writer1 = new SyncSimpleArrayWriter(1, sharedSyncSimpleArray);
		SyncSimpleArrayWriter writer2 = new SyncSimpleArrayWriter(11, sharedSyncSimpleArray);
		
		// execute the tasks to write to the shared SimpleArray
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(writer1);
		executorService.execute(writer2);
		
		executorService.shutdown();
		
		System.out.println("ExecutorService shutdown");
		
		try
		{
			// wait for 1 minute for both writers to finish executing
			boolean tasksEnded = executorService.awaitTermination(1, TimeUnit.MINUTES);
			
			if (tasksEnded)
			{
				System.out.printf("%nContents of SimpleArray:%n");
				System.out.println(sharedSyncSimpleArray);	// print contents
			}
			else
			{
				System.out.println("Timed out while waiting for tasks to finish");
			}
		}
		catch (InterruptedException ex)
		{
			ex.printStackTrace();
		}
		
	}
}









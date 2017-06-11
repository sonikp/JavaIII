package week7;
// fig 23.7

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;

public class SimpleSharedArrayTestMain
{
	public static void main(String[] args)
	{
		// construct the shared object
		SimpleArray sharedSimpleArray = new SimpleArray(6);
		
		// create two tasks to write to the shared SimpleArray
		SimpleArrayWriter writer1 = new SimpleArrayWriter(1, sharedSimpleArray);
		SimpleArrayWriter writer2 = new SimpleArrayWriter(11, sharedSimpleArray);
		
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
				System.out.println(sharedSimpleArray);	// print contents
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









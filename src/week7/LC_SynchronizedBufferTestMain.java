package week7;
// fig 23.17 // Synchronized access to a shared integer using the Lock and Condition interfaces (LC)

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LC_SynchronizedBufferTestMain
{
	public static void main(String[] args) throws InterruptedException
	{
		// create new thread pool with two threads
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		// create SychronizedBuffer to store integers
		LC_Buffer sharedLocation = new LC_SynchronizedBuffer();
		
		System.out.printf("%-40s%s\t\t%s%n%-40s%s%n%n", "Operation", "Buffer", "Occupied", "---------", "------\t\t--------");
	
		
		executorService.execute(new LC_Producer(sharedLocation));
		executorService.execute(new LC_Consumer(sharedLocation));
		
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.MINUTES);
			
	}

	
	
}

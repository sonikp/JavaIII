package week7;
// fig 23.17 // Thread safe - synchronized, using Object methods wait() and notifyAll()

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ADV_SynchronizedBufferTestMain
{
	public static void main(String[] args) throws InterruptedException
	{
		// create new thread pool with two threads
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		// create BlockingBuffer to store ints
		ADV_Buffer sharedLocation = new ADV_SynchronizedBuffer();
		
		System.out.printf("%-40s%s\t\t%s%n%-40s%s%n%n", "Operation", "Buffer", "Occupied", "---------", "------\t\t--------");
		
		executorService.execute(new ADV_Producer(sharedLocation));
		executorService.execute(new ADV_Consumer(sharedLocation));
		
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.MINUTES);
			
	}

	
	
}

package week7;
// fig 23.17 // Synchronized access to a shared three-element bounded buffer (BB)

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BB_CircularBufferTestMain
{
	public static void main(String[] args) throws InterruptedException
	{
		// create new thread pool with two threads
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		// create BlockingBuffer to store ints
		BB_CircularBuffer sharedLocation = new BB_CircularBuffer();
		
		// display the initial state of the CircularBuffer
		sharedLocation.displayState("Initial State");
	
		
		executorService.execute(new BB_Producer(sharedLocation));
		executorService.execute(new BB_Consumer(sharedLocation));
		
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.MINUTES);
			
	}

	
	
}

package week7;
// fig 23.13 // Thread safe - synchronized, using ArrayBlockingQueue for implementing shared buffer

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ABQ_BlockingBufferTestMain
{
	public static void main(String[] args) throws InterruptedException
	{
		// create new thread pool with two threads
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		// create BlockingBuffer to store ints
		ABQ_Buffer sharedLocation = new ABQ_BlockingBuffer();
		
		executorService.execute(new ABQ_Producer(sharedLocation));
		executorService.execute(new ABQ_Consumer(sharedLocation));
		
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.MINUTES);
			
	}

	
	
}

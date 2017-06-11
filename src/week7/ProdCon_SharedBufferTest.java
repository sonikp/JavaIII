package week7;
// fig 23.13

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ProdCon_SharedBufferTest
{
	public static void main(String[] args) throws InterruptedException
	{
		// create new thread pool with two threads
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		// create UnsynchronizedBuffer to store ints
		ProdCon_Buffer sharedLocation = new ProdCon_UnsynchronizedBuffer();
		
		System.out.println("Action\t\tValue\tSum of Produced\t\tSum of Consumed");
		System.out.printf("------\t\t-----\t---------------\t\t----------------%n%n");
		
		// execute the Producer and Consumer, giving each access to the sharedLocation
		executorService.execute(new ProdCon_Producer(sharedLocation));
		executorService.execute(new ProdCon_Consumer(sharedLocation));
		
		executorService.shutdown(); // terminate app when tasks complete
		executorService.awaitTermination(1, TimeUnit.MINUTES);
		
	}

	
	
}

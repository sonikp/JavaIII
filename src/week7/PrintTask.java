package week7;
// Fig 23.3

import java.security.SecureRandom;



public class PrintTask implements Runnable {
	private static final SecureRandom generator = new SecureRandom();
	private final int sleepTime;
	private final String taskName;
	
	// constructor 
	public PrintTask(String taskName) {
		this.taskName = taskName;
		
		// pick random sleep time betwee 0 and 5 seconds
		sleepTime = generator.nextInt(5000);
	}
	
	// method run contains the code that a thread will execute
	public void run() {
		try // put thread to sleep for sleepTime amount of time
		{
			System.out.printf("%s going to sleep for %d milliseconds.%n", taskName, sleepTime);
			Thread.sleep(sleepTime);
		}
		catch (InterruptedException exception)
		{
			exception.printStackTrace();
			Thread.currentThread().interrupt(); 	// re-interrupt the thread
		}
		
		// print task name
		System.out.printf("%s done sleeping%n", taskName);
	}
}
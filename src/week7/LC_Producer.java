package week7;
// fig 23.10 // Synchronized access to a shared integer using the Lock and Condition interfaces (LC)

import java.security.SecureRandom;

public class LC_Producer implements Runnable
{
	private static final SecureRandom generator = new SecureRandom();
	private final LC_Buffer sharedLocation;	// reference to shared object
	
	// constructor
	public LC_Producer(LC_Buffer sharedLocation)
	{
		this.sharedLocation = sharedLocation;
	}
	
	// store values from 1 to 10 in shareLocatoin
	public void run()
	{
		int sum = 0;
		
		for (int count = 1; count <= 10; count++)
		{
			try //  sleep 0 to 3 seconds, then place value in Buffer
			{
				Thread.sleep(generator.nextInt(3000));
				sharedLocation.blockingPut(count);
				sum += count;
			}
			catch (InterruptedException ex)
			{
				Thread.currentThread().interrupt();
			}
		}
		
		System.out.printf("Producer done producing%nTerminating Producer%n");
	}
}








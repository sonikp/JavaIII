package week7;
// fig 23.10 // not thread safe - unsynchronized buffer

import java.security.SecureRandom;

public class ProdCon_Producer implements Runnable
{
	private static final SecureRandom generator = new SecureRandom();
	private final ProdCon_Buffer sharedLocation;	// reference to shared object
	
	// constructor
	public ProdCon_Producer(ProdCon_Buffer sharedLocation)
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
				System.out.printf("\t%2d%n", sum);
			}
			catch (InterruptedException ex)
			{
				Thread.currentThread().interrupt();
			}
		}
		
		System.out.printf("Producer done producing%nTerminating Producer%n");
	}
}








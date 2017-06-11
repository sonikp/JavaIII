package week7;
// fig 23.11

import java.security.SecureRandom;

public class ProdCon_Consumer implements Runnable
{
	private static final SecureRandom generator = new SecureRandom();
	private final ProdCon_Buffer sharedLocation;	// reference to the shared object
	
	// constructor
	public ProdCon_Consumer(ProdCon_Buffer sharedLocation)
	{
		this.sharedLocation = sharedLocation;
	}
	
	// read sharedLocation's value 10 times and sum value
	public void run()
	{
		int sum = 0;
		
		for (int count = 1; count <= 10; count++)
		{
			// sleep 0 to 3 seconds, read value from buffer and add to sum
			try
			{
				Thread.sleep(generator.nextInt(3000));
				sum += sharedLocation.blockingGet();
				System.out.printf("\t\t\t\t%2d%n", sum);
			}
			catch (InterruptedException ex)
			{
				Thread.currentThread().interrupt();
			}
		}
		
		System.out.printf("%n%s %d%n%s%n", "Consumer read values totalling", sum, "Terminating Consumer");
	}
}
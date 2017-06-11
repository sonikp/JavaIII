package week7;
// fig 23.16 // Thread safe - synchronized, using Object methods wait() and notifyAll()

public class ADV_SynchronizedBuffer implements ADV_Buffer
{
	private int buffer = -1;
	private boolean occupied = false;
	
	// place value into buffer
	public synchronized void blockingPut(int value) throws InterruptedException
	{
		// while there are no empty locations, place thread in waiting state
		while(occupied)
		{
			// output thread info and buffer info, then wait
			System.out.println("Producer tries to write."); // for demo only
			displayState("Buffer full. Producer waits.");	// for demo only
			wait();
		}
		
		buffer = value; 	// set new buffer value
		
		// indicate producer cannot store another value until consumer retrieves current buffer value
		occupied = true;
		
		displayState("Producer writes " + buffer);	// for demo only
		
		notifyAll();	// tell waiting thread(s) to enter runnable stated; 
	}	// end method blockingPut(), release lock on SynchronizedBuffer()
	
	// return value from buffer
	public synchronized int blockingGet() throws InterruptedException
	{
		// while no data to read, place thread in waiting state
		while (!occupied)
		{
			// output thread info and buffer info, then wait
			System.out.println("Consumer tries to read.");
			displayState("Buffer empty. Consumer waits.");
			wait();
		}
		
		// indicate that producer can store another value because consumer just retrieved buffer value
		occupied = false;
		
		displayState("Consumer reads " + buffer);
		
		notifyAll();	// tell waiting thread(s) to enter runnable state
		
		return buffer;
	}
	
	// display current operation and buffer state
	private synchronized void displayState(String operation)
	{
		System.out.printf("%-40s%d\t\t%b%n%n", operation, buffer, occupied);
	}
}	// end class ADV_SynchronizedBuffer
















package week7;

// fig 23.14 // Thread safe - synchronized, using ArrayBlockingQueue for implementing shared buffer

import java.util.concurrent.ArrayBlockingQueue;

public class ADV_BlockingBuffer implements ABQ_Buffer
{
	private final ArrayBlockingQueue<Integer> buffer; 	// shared buffer
	
	public ADV_BlockingBuffer()
	{
		buffer = new ArrayBlockingQueue<Integer>(1);
	}
	
	// place value into buffer
	public void blockingPut(int value) throws InterruptedException
	{
		buffer.put(value);
		System.out.printf("%s%2d\t%s%d%n", "Producer writes ", value, "Buffered cells occupied: ", buffer.size());
	}
	
	// return value from buffer
	public int blockingGet() throws InterruptedException
	{
		int readValue = buffer.take(); // remove value from buffer
		System.out.printf("%s %2d\t%s%d%n", "Consumer reads ", readValue, "Buffer cells occupied: ", buffer.size());
		
		return readValue;
	}
	
	
	
}

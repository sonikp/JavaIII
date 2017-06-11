package week7;
// fig 23.12 // not thread safe - unsynchronized buffer

public class ProdCon_UnsynchronizedBuffer implements ProdCon_Buffer
{
	private int buffer = -1;
	
	// place value into buffer
	public void blockingPut(int value) throws InterruptedException
	{
		System.out.printf("Producer writes\t%2d", value);
		buffer = value;
	}
	
	// return value from buffer
	public int blockingGet() throws InterruptedException
	{
		System.out.printf("Consumer reads\t%2d", buffer);
		return buffer;
	}
}
package week7;
// fig 23.9 // not thread safe - unsynchronized buffer

public interface ProdCon_Buffer
{
	// place int value into buffer
	public void blockingPut(int value) throws InterruptedException;
	
	// return int value from Buffer
	public int blockingGet() throws InterruptedException;
}
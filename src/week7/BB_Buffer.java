package week7;
// fig 23.9 // Synchronized access to a shared three-element bounded buffer (BB)

public interface BB_Buffer
{
	// place int value into buffer
	public void blockingPut(int value) throws InterruptedException;
	
	// return int value from Buffer
	public int blockingGet() throws InterruptedException;
}
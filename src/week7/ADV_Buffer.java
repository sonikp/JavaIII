package week7;
// fig 23.9 // Thread safe - synchronized, using Object methods wait() and notifyAll()

public interface ADV_Buffer
{
	// place int value into buffer
	public void blockingPut(int value) throws InterruptedException;
	
	// return int value from Buffer
	public int blockingGet() throws InterruptedException;
}
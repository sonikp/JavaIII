package week7;
// fig 23.9 //Thread safe - synchronized, using ArrayBlockingQueue for implementing shared buffer


public interface ABQ_Buffer
{
	// place int value into buffer
	public void blockingPut(int value) throws InterruptedException;
	
	// return int value from Buffer
	public int blockingGet() throws InterruptedException;
}
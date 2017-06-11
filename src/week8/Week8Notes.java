package week8;

public class Week8Notes
{
	
}

/*

Week 8 Module 5 Multithreading

What is a thread?

Thread refers to the thread of execution, more specifically, it can be refered to as a light-weight process
Threads can be run where multiple threads can run within a single application.

At a minimum all java applications run at least two threads
- main thread
- garbage collection thread
- with the use of Swing GUI, an additional thread, the event-dispatch thread is introduced

Generally, a Swing GUI app, the main method terminates very quickly
typically, the main method instantiates the first level GUI object, registers them with one another as necessary,
and terminates them. The app contineus to run from within the event-dispatch thread, while the memory is managed
by the garbage collection thread.
Even though an unhandled exception might get thrown out, the two threads will continue running.

Note, although the above describes two/three threads, these are not considered multithreaded, until
additional threads are introduced within the application.


Thread life-cycle stated

===> New (starts in new state where it becomes runnable, either running or....)

Runnable (thereafter it can become.....)

| waiting	|	timed waiting	| blocked	| terminated 	|

====> end


Threads have priorities, 10 possible states, MAX_PRIORITY, MIN_PRIORITY.
This specifies the priority to the CPU time, so long as this does not impact
the stability of the CPU/APP/Environment

Deadlock - a situation where the thread is never granted access to the CPU
Resource Contention Problems - multiple threads interupting each other

Mechanisms were developed to enforce "mutual exclusion"
Java developed the mechanism and keyword = SYNCHRONIZED
Therefore this must recognize the ability to complete an entire block of execution to
avoid a corrupted or inconsistent state

Runnables:
The prefered way of representing a thread is by implementing the Runnable interface
One can the instantiate a thread object by passing a reference to a runnable object as a parameter to the 
Thread constuctor. 

A subsequent invocation of the thread method start() will the start the thread.
Assuming class Task implements the Runnable interface;

	Thread taskThread = new Thread(new Task());
	taskThread.start();
	
The Runnable interface is implemented by providing a run() method
Threads need to have a way of entering a waiting state, a timed waiting, or a blocked state

- entering a timed waiting state  = sleep();

Executor Framework;
Assists in the management of threads within an application
The ExecutorService interface extends the Executor class, declaring additional thread management methods
The Executor class has a static method newCachedThreadPool(), which creates an Executor object that works with
cached thread pool

	ExecutorService executorService = Executors.newCachedThreadPool();

The ExecutorService can then be used to start a series of threadsby means of the execute() method

	executorService.execute(runnable1);
	executorService.execute(runnable2);
	executorService.execute(runnable3);
	executorService.shutdown();

- the parameter passed to the ExecutorService's execute method is a reference to a runnable
- will create a new thread object as necessary, and assign the given runnable to be run by the new thread
- manages the threads it creates as a pool of threads
- when it terminates, it is not destroyed, the ExecutorService keeps a reference to it within its thread pool
- When a new runnable is passed to the execute method,the ES first checks to see if an unassigned thread is available
- this is the way that the ES "caches its threads within its thread pool."

- the ExecutorService caches its threads within a "thread pool"
- by invoking the shutdown() method, the ExecutorService object knows no more runnables are being offered for it to manage
- ExecutorService object will remove thread reference once they terminate, emptying the thread pool one thread at a time.

Synchronization
- must ensure "mutal exclusion", done using the keyword "synchronized"
- Every Java object has a monitor and monitor lock
- Monitor manages access to the synchromixed sections of its object
Example
	public synchronized void foo() {
	
	}
	
- a code block is denoted as synchronized if the synchronized keyword precedes it
	
	synchronized ( this ) {
	......
	}
	
- NOTE: that an object reference is supplied as a parameter to the synchronized block
- the supplied object reference is a reference to the object whose monitor and monitor lock will be used to synchronize the code block
- the supplied object reference is usually (but not necessarily) the "this" reference

How does this work?
- thread attempting to enter a synchronized section of an object, the object's monitor first checks to see if the lock is available
- if so, then monitor allows the thread to enter the synchronized section
- when a 2nd thread comes along, monitor determines the "lock is currently held", then places new thread into a queue
- NOTE; a held lock only blocks access to a synchronized section of a object
	- therefore, a held lock blocks threads from entering the synchronized method the lock-holding thread is currently
	executing, but it also blocks threads from entering all the other synchronized methods and synchronized code blocks
	belonging to the same object
	- MONITOR LOCKS OPERATE AT THE OBJECT LEVEL
	- non-synchronized methods can be accessed quite readily

- By using the 'synchronized' keyword, you ensure that your methods are "thread-safe"
- REMEMBER, the more you synchronize an application, the more it represents a single-threaded application
- GeneralRule: keep synchronized sections as small and as few as possible; synchronize enough to ensure thread-safety but no more

- NOTE: in some circumstances a thread that is executing within a synchronized section may determine it cannot continue its task
	- in such a case, the thread may invoke the Object method wait();, which releases the monitor lock.
	- another thread may determine that circumstances have changed, such that a waiting thread may now be able to continue with its task
	- this thread can signal the waiting thread by invoking the object method notify();
	- situations where multiple threads might be waiting in "indefinite postponement" (starvation). Therefore invoking notifyAll() will 
	grant all threads the opportunity to enter their respective synchronized sections
	
Locks and Conditions	
- is another approach to multithreaded synchronization
- Locks: have multiple locks to help coordinate the threads
	- for any given lock, can have multiple conditions that your thread waits upon
	- "ReentrantLock class" implements the Lock interface
	- ReentrantLock constructor accepts a boolean parameter that specifies whether the lock should use its fairness policy
	- ReentrantLock fairness policy is to give the lock to the longest waiting thread
Example:
- newCondition() method creates a Condition that can be waited upon for that lock

	private final Lock channelLock = new ReentrantLock(true);
	
	private final Condition canSend = channelLock.newCondition();
	private final Condition canReceive = channelLock.newCondition();
	
- waiting threads can be interupted.
- threads can be made to wait with a timeout
- threads may wait on multiple condition objects
- these features are NOT available with synchronized keyword
- Locks and Conditions tend to result in more complicated thread dynamics and are often error-prone and deadlock (indefinite postponement) are common
- Recommended: use the 'synchronized' keyword approach if possible
- locks are released by invoking the unlock()
- best way is:
	
	finally
	{
		channelLock.unlock();
	}
	
GUI Multithreading
- NOTE: event-dispatch thread is not thread-safe
- Class SwingWorker allows to safely merge multithreading with GUI operations
- Important SwingWorker methods
	- doInBackground()
	- done()
	- execute()
	- get()
	- publish()
	- process()
	- setProgress()

- SwingWorker is implemented as a generic class
	- the first SwingWorker type parameter denotes the type that is published
	- the second type parameter denotes the type that is processed
	- 
































*/
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

up to slide 20




























*/
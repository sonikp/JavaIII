package week7;

public class Week7Notes
{
	
}

/*

Eclipse:
http://javapapers.com/core-java/eclipse-shortcuts/
http://javapapers.com/core-java/top-10-java-debugging-tips-with-eclipse/



Threads (a lot of threads will be in java 4)

CHAPTER 23

(this shows the states a thread can work in)

fig 23.1 Thread states and life cycles

NEW	=	 thread created
|
RUNNABLE = thread ready in a runnable state
|	|	|	|
| WAITING	||	TIMED_WAITING	||	TERMINATED	||	BLOCKED	|	=	these are all the states that the thread can operate in.


Threads = lightweight process

in java how many threads are there?

Beginners Java apps were:

1. garbage collector
2. main thread ; program execution = public static void main(string[] args)

In a gui:

1. event dispatch thread (display)
2. garbage collection
3. Main thread

IMPORTANT:
All java programs have at a minimum 2 threads, garbage collection, and main

Other threads
- event dispatch thread
- 

This is an example of an event driven system, the application responds to events.



FIG 23.3

implements Runnable // is an implementation of a thread

fig 23.4 TaskExecutor
fig 23.5 SimpleArray
fig 23.6 ArrayWriter
fig 23.7 SharedArray
fig 23.9 Buffer
fig 23.8 SimpleArray
fig 23.14 BlockingBuffer

what does "project"/"clean" do?

fig 23.16 SynchronizedBuffer.java

line 47: % buffer.length, //=> nifty trick for working with circular buffers

Important: runnable is different from run-state or running


Additional reading:
http://www.javacreed.com/understanding-threads-monitors-and-locks/




*/
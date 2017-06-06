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


==========Final weeks notes=================
chapter 23:

Class SwingWorker definitions:

do In Background - Crunch Stuff!! (Worker Thread)
done - wrap up code (event dispatch thread)
execute - schedule swing worker object (to execute in worker thread)
get - wait for finished computation
publish - sends partial/intermediate results to "process" method
process - receives partial/intermediate results from "publish" method and processes those results
setProgress - set progress property
 
fig 23.20 

synchronized (keyword) =  (multi-threading)
- is the key word to ensure thread safety.
- ensures only one thread at a time can safely get into the method 
- makes use of a monitor lock. (All java objects have a monitor lock)
- the lock is given to that thread.
- lock operates on the entire object, only with respect to synchronized methods

examples:
synchronized(this) {

}
synchronized(new Object) {

}

- All objects can use monitor locks
 Another class that can be useful with similar functions is the swingworker class
 SwingWorkerClass Chapter 23.11
 
 fig 23.24
 
 fig 23.26
 
 SwingWorker < Integer, Integer > (second item is an intermediary type. When this is not used, use the "Object" tag)

fig 23.18 circular buffers
 
fig 23.20 reentrantlock = allows for locking of an object, however when a method calls a locked method, that is part of the thread that has caused the lock, then the locked thread 
locks that locked method in order to complete and let the original locking thread to complete

Synchronized keyword = locks and unlocks within a designated areas of code within the area that is designated as "locked". 

Concurrent locks =  allows for locking and unlocking of methods, by specifying .unlock() at any time you need. this means that
it is not necessary to lock and unlock within the same section of code.

?? figuring out errors and debuging code problems
Tool: profiler =  allows you to get metrics on the executed application. 
Step through the debugger

Chapter 23.24 - Interfaces Callable and Future objects

MVC is one example of a set of architectural structures and design patterns 















*/
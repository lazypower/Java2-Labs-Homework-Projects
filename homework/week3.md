

###What is thread.isAlive() method, and what does it tell you about the thread?*

 thread.isalive() will return a predicate value after testing to see if the thread is active. 

cited: http://docs.oracle.com/javase/1.4.2/docs/api/java/lang/Thread.html

###Find out the difference between a deamon thread and a user thread.

In java, daemon threads are typically threads spawned from a user thread, and perform services for the calling thread. You can explicitly define a DaemonThread by calling the member setDaemon(true) on a thread object before it has started.  Some examples of daemon threads - Clock Handler, idle, GarbageCollector, screenUpdater.  The difference between the two types of threads is fairly straightforward: If the java runtime determines that the only threads running in an application are daemon threads the java runtime promptly closes the aplication. In order for an application to continue running, it must always have at least one live user thread. 

cited: http://www.xyzws.com/javafaq/what-is-difference-between-user-and-daemon-thread-in-java/196

###Create a new thread without specifying its group in the constructor.

Threads that are created without explicilty assigning the threadgroup in the constructor becomes part of the "main" thread group.  When an application first starts up, the Java runtime system creates a ThreadGroup named "main". So, unless specified otherwise, all new threads that you create become members of the "main" thread group.

cited: http://www.ecst.csuchico.edu/~amk/foo/cscijava/tutorial/java/threads/group.htm

###What is the state of a thread when it blocks an I/O and the initial state of a thread after it is created and started?

A thread will be put to sleep when it is in a "blocked I/O" state. A thread in the blocked state is waiting for a monitor lock to enter a syncrhonized block/method or reenter a synchronized block after calling Object.wait.  As a thread is created and started, it enters the "ready" state.

cited: http://docs.oracle.com/javase/1.5.0/docs/api/java/lang/Thread.State.html

###Is it possible to call the wait() method in a non-synchronized block


A wait() only makes sense when there is also a notify(), so it's always about communication between threads, and that needs synchronization to work correctly. One could argue that this should be implicit, but that would not really help.

cited: http://stackoverflow.com/questions/2779484/why-wait-should-always-be-in-synchronized-block


1) b

2) b,d,e

3) d

4) 




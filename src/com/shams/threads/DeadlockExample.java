package com.shams.threads;

public class DeadlockExample {
  //Thread t1 starts and calls test1 method by taking the object lock of s1.
  //Thread t2 starts and calls test1 method by taking the object lock of s2.
  //t1 prints test1-begin and t2 prints test-2 begin and both waits for 1 second, so that both threads can be started if any of them is not.
  //t1 tries to take object lock of s2 and call method test2 but as it is already acquired by t2 so it waits till it become free. It will not release lock of s1 until it gets lock of s2.
  //Same happens with t2. It tries to take object lock of s1 and call method test1 but it is already acquired by t1, so it has to wait till t1 release the lock. t2 will also not release lock of s2 until it gets lock of s1.
  //Now, both threads are in wait state, waiting for each other to release locks. Now there is a race around condition that who will release the lock first.
  //As none of them is ready to release lock, so this is the Dead Lock condition.
  //When you will run this program, it will be look like execution is paused.
  public static void main(String[] args) {
    // creating one object
    Shared s1 = new Shared();

    // creating second object
    Shared s2 = new Shared();

    // creating first thread and starting it
    Thread1 t1 = new Thread1(s1, s2);
    t1.start();

    // creating second thread and starting it
    Thread2 t2 = new Thread2(s1, s2);
    t2.start();

    // sleeping main thread
    Util.sleep(2000);
  }
} // end of DeadlockExample

// Java program to illustrate Deadlock
// in multithreading.
class Util {
  // Util class to sleep a thread
  static void sleep(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

// This class is shared by both threads
class Shared {
  // first synchronized method
  synchronized void test1(Shared s2) {
    System.out.println("test1-begin");
    Util.sleep(1000);

    // taking object lock of s2 enters
    // into test2 method
    s2.test2();
    System.out.println("test1-end");
  }

  // second synchronized method
  synchronized void test2() {
    System.out.println("test2-begin");
    Util.sleep(1000);
    // taking object lock of s1 enters
    // into test1 method
    System.out.println("test2-end");
  }
}


class Thread1 extends Thread {
  private Shared s1;
  private Shared s2;

  // constructor to initialize fields
  public Thread1(Shared s1, Shared s2) {
    this.s1 = s1;
    this.s2 = s2;
  }

  // run method to start a thread
  @Override
  public void run() {
    // taking object lock of s1 enters
    // into test1 method
    s1.test1(s2);
  }
}


class Thread2 extends Thread {
  private Shared s1;
  private Shared s2;

  // constructor to initialize fields
  public Thread2(Shared s1, Shared s2) {
    this.s1 = s1;
    this.s2 = s2;
  }

  // run method to start a thread
  @Override
  public void run() {
    // taking object lock of s2
    // enters into test2 method
    s2.test1(s1);
  }
}




package com.shams.threads.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockExample {
  public static void main(String[] args) {
    Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();

    Runnable runnable1 = new Runnable1(lock1, lock2);
    Runnable runnable2 = new Runnable2(lock1, lock2);
    Thread t1 = new Thread(runnable1);
    Thread t2 = new Thread(runnable2);

    t1.start();
    t2.start();

    // Output :
    //Thread-1 attempting to lock Lock 2
    //Thread-0 attempting to lock Lock 1
    //Thread-0 locked lock 1
    //Thread-1 locked lock 2
    //Thread-1 attempting to lock Lock 1
    //Thread-0 attempting to lock Lock 2
  }
}

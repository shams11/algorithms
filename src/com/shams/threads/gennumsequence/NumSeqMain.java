package com.shams.threads.gennumsequence;

public class NumSeqMain {

  public static void main(String[] args) {
    NumGen ng = new NumGen(20, 3);
    NumRunnable runnable1 = new NumRunnable(ng, 1);
    NumRunnable runnable2 = new NumRunnable(ng, 2);
    NumRunnable runnable3 = new NumRunnable(ng, 0);

    Thread t1 = new Thread(runnable1, "Thread 1");
    Thread t2 = new Thread(runnable2, "Thread 2");
    Thread t3 = new Thread(runnable3, "Thread 3");
    t1.start();
    t2.start();
    t3.start();
  }
}

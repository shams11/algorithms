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

  // Output :
  //Thread 1 1
  //Thread 2 2
  //Thread 3 3
  //Thread 1 4
  //Thread 2 5
  //Thread 3 6
  //Thread 1 7
  //Thread 2 8
  //Thread 3 9
  //Thread 1 10
  //Thread 2 11
  //Thread 3 12
  //Thread 1 13
  //Thread 2 14
  //Thread 3 15
  //Thread 1 16
  //Thread 2 17
  //Thread 3 18
  //Thread 1 19
  //Thread 2 20
}

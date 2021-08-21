package com.shams.threads;

public class RaceCondition {
  public static void main(String[] args) {
    Runnable runnable = new MyRunnable();
    Thread t1 = new Thread(runnable, "Thread 1");
    Thread t2 = new Thread(runnable, "Thread 2");
    t1.start();
    t2.start();
  }

  public static class MyRunnable implements Runnable {
    // shared variable by 2 threads
    int count = 0;
    @Override
    public void run() {
      for(int i = 0; i < 1000000; ++i) {
        // without synchronized, no thread will reach to 2 million
        // because of write visibility problem

        // with synchronized, one of the threads will reach to 2 million
        synchronized (this) {
          this.count++;
        }
      }
      System.out.println(Thread.currentThread().getName() + " : " + count);
    }
  }
}

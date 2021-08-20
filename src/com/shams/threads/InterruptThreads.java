package com.shams.threads;

import java.util.concurrent.atomic.AtomicBoolean;

public class InterruptThreads {
  public static void main(String[] args) {
    Thread thread1 = new Thread(() -> {
      while(!Thread.currentThread().isInterrupted()) {
        // check in the loop, if the thread is not interrupted, then execute.
        // else come out of the loop
      }
    });

    // After 10 mins
    thread1.interrupt();
  }


  // Another way is to use volatile variable to stop the thread

  void process() {
    // 1. Create a task and submit to  a thread
    MyTask task = new MyTask();
    Thread t1 = new Thread();
    t1.start();

    // 2. Time out for 10 mins

    // 3. ask task to stop using volatile
    task.keepRunning = false;
    // For AtomicBoolean
    // task.stop();


    // Timeout for 10 mins
    try {
      Thread.sleep(10 * 60 * 1000);
    } catch (InterruptedException e) {
        // process exception
    }
  }

  // using volatile
  private class MyTask implements Runnable {
    public volatile boolean keepRunning = true;
    @Override
    public void run() {
      while(keepRunning) {
        // execute the task

        // For I/O calls, like DB operations, jdbc library or httpClient library
        // will time out after certain time

        // jdbc.storedProcedureCall();
        // httpClient.request();
      }
    }
  }

  // using AutomicBoolean

  private class MyTask1 implements Runnable {
    public AtomicBoolean keepRunning = new AtomicBoolean();
    @Override
    public void run() {
      while(keepRunning.get()) {
        // execute the task
      }
    }

    public void stop() {
      keepRunning.set(false);
    }
  }
}

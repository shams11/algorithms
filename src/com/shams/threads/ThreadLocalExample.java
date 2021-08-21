package com.shams.threads;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalExample {
  public static void main(String[] args) {
    ThreadLocal<String> threadLocal = new ThreadLocal<>();

    // Thread 1
    Thread t1 = new Thread( () -> {
      threadLocal.set("Thread 1");
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      String value = threadLocal.get();
      System.out.println("Thread 1 : " + value);
    });


    // Thread 2
    Thread t2 = new Thread( () -> {
      threadLocal.set("Thread 2");
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      String value = threadLocal.get();
      System.out.println("Thread 2 : " + value);
    });

    t1.start();
    t2.start();
  }
}


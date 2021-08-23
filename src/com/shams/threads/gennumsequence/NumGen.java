package com.shams.threads.gennumsequence;

public class NumGen {

  int number = 1;
  int max;
  int threads;

  public NumGen(int max, int threads) {
    this.max = max;
    this.threads = threads;
  }


  public void generateSeq(int remainder) throws InterruptedException {
    while (number < max - 1) {
      synchronized (this) {
        // while here because, when thread get lock, it should check again whether it can print
        // OR wait. if it was if block, then thread will not wait again
        while (number % threads != remainder) {
          wait();
        }
        System.out.println(Thread.currentThread().getName() + " " + number);
        number++;
        notifyAll();
      }
    }


  }
}

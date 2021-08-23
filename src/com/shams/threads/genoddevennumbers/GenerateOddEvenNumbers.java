package com.shams.threads.genoddevennumbers;


public class GenerateOddEvenNumbers {
  public static void main(String[] args) {
    NumGen numGen = new NumGen(20, 2);
    NumRunnable runnable1 = new NumRunnable(numGen, 1);
    NumRunnable runnable2 = new NumRunnable(numGen, 0);

    Thread t1 = new Thread(runnable1);
    Thread t2 = new Thread(runnable2);

    t1.start();
    t2.start();
  }
}

// Runnable Task
class NumRunnable implements Runnable {
  NumGen numGen;
  int remainder;

  public NumRunnable(NumGen numGen, int remainder) {
    this.numGen = numGen;
    this.remainder = remainder;
  }

  @Override
  public void run() {
    try {
      numGen.generateOddEven(remainder);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

// Number generation class
class NumGen {
  int number = 1;
  int max;
  int threads;


  public NumGen(int max, int threads) {
    this.max = max;
    this.threads = threads;
  }

  public void generateOddEven(int remainder) throws InterruptedException {
    while (number < max) {
      synchronized (this) {
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
// Output :
//Thread-0 1
//Thread-1 2
//Thread-0 3
//Thread-1 4
//Thread-0 5
//Thread-1 6
//Thread-0 7
//Thread-1 8
//Thread-0 9
//Thread-1 10
//Thread-0 11
//Thread-1 12
//Thread-0 13
//Thread-1 14
//Thread-0 15
//Thread-1 16
//Thread-0 17
//Thread-1 18
//Thread-0 19
//Thread-1 20

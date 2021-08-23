package com.shams.threads.gennumsequence;

public class NumRunnable implements Runnable {
  NumGen numGen;
  int remainder;

  public NumRunnable(NumGen numGen, int remainder) {
    this.numGen = numGen;
    this.remainder = remainder;
  }

  @Override
  public void run() {
    try {
      numGen.generateSeq(remainder);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

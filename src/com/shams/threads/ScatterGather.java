package com.shams.threads;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ScatterGather {
  public static void main(String[] args) {

  }

  ExecutorService threadPool = Executors.newFixedThreadPool(4);
  private Set<Integer> getPrices(int productId) throws InterruptedException {
    Set<Integer> prices = Collections.synchronizedSet(new HashSet<>());
    // 3 is number of times count down should be invoked before threads can pass through {@link #await}
    CountDownLatch latch = new CountDownLatch(3);
    threadPool.submit(new Task("url1", 12, prices, latch));
    threadPool.submit(new Task("url2", 13, prices, latch));
    threadPool.submit(new Task("url3", 14, prices, latch));

    // wait for every task to count down. i.e wait for count = 0 from initial count of 3
    latch.await(3, TimeUnit.SECONDS); // do not wait more than 3 sec
    return prices;
  }

  private class Task implements Runnable {
      private Set<Integer> prices;
      private CountDownLatch latch;
    Task(String url, int productId, Set<Integer> prices, CountDownLatch latch) {
        this.latch = latch;
        this.prices = prices;
    }
    @Override
    public void run() {
      int price = 0;
      // make http call

      prices.add(price);
      latch.countDown(); // if added after countdown, then ignored
    }
  }
}

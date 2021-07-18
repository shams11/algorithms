/***
 * https://www.youtube.com/watch?v=FU4WlwfS3G0&ab_channel=SystemDesignInterview
 * */
package com.shams.algos;

public class RateLimit {
  int currentBucketSize;
  int maxBucketSize;
  int refillRate;
  long lastRefillTime = System.nanoTime();

  RateLimit(int maxBucketSize, int refillRate) {
    this.maxBucketSize = maxBucketSize;
    this.refillRate = refillRate;
  }

  // ex : initially max bucket size = 10
  // refill rate = 10 tokens/ per second
  boolean allowRequest(int tokens) {
    refill();
    if(currentBucketSize > tokens) {
      currentBucketSize -= tokens;
      return true;
    }
    return  false;
  }

  private void refill() {
    long now = System.currentTimeMillis();
    double tokensToAdd = (now - lastRefillTime) * refillRate / 1000000000;
    currentBucketSize = (int) Math.min(maxBucketSize, currentBucketSize + tokensToAdd);
    lastRefillTime = now;
  }
}

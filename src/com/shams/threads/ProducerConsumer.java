/**
 * https://www.youtube.com/watch?v=UOr9kMCCa5g&list=PLhfHPmPYPPRmHL24Ry8rzni2XgwFeooVE&index=2&ab_channel=DefogTech
 * */
package com.shams.threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {
  public static void main(String[] args) {

  }

  public static class E {

  }
  private int capacity;
  private ReentrantLock lock = new ReentrantLock();
  private Condition nonEmpty = lock.newCondition();
  private Condition notFull = lock.newCondition();
  Queue<E> queue = new LinkedList<>();

  public ProducerConsumer(int capacity) {
    this.capacity = capacity;
  }

  public void put(E e) {
    lock.lock();
    try {
      // if Queue is full
      if(queue.size() == capacity) {
        // thread should wait
        notFull.wait();
      }
      queue.add(e);
      nonEmpty.signalAll(); // notify other threads
    } catch (InterruptedException interruptedException) {
      interruptedException.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  public E get() {
    E item = null;
    lock.lock();
    try {
      if(queue.isEmpty()) {
        nonEmpty.wait();
      }
      item = queue.poll();
      notFull.signalAll();
      
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
    return item;
  }
}

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
      while(queue.size() == capacity) {
        // thread should wait i.e block the thread
        // Thread will wait for someone to trigger this notFull condition
        // Thread releases the lock here and goes to wait state
        notFull.wait();
      }
      queue.add(e);
      // notify consumer threads for nonEmpty condition
      nonEmpty.signalAll();
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
      // while here because, if 2 threads were waiting to consume the item, then one threads
      // acquires the lock consumers it, then releases the lock.

      // Thread 2 acquires the lock and trie to get item from queue, it will get NULL.
      // so, if while is there then it will check queue empty condition and goes to
      // wait state again
      while(queue.isEmpty()) {
       // i.e block the thread
        // Thread will wait for someone to trigger this nonEmpty condition
        // Thread releases the lock here and goes to wait state
        nonEmpty.wait();
      }
      item = queue.poll();
      // notify producer threads for notFull condition
      notFull.signalAll();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
    return item;
  }
}

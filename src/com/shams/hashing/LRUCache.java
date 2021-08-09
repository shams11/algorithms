/**
 * https://www.geeksforgeeks.org/design-a-data-structure-for-lru-cache/?ref=rp
 * https://leetcode.com/problems/lru-cache/
 * */
package com.shams.hashing;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
  int count;
  int capacity;
  Map<Integer, Node> map;
  Node head;
  Node tail;

  public class Node {
    int key;
    int value;
    Node next;
    Node prev;
    Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  public LRUCache(int capacity) {

    this.capacity = capacity;
    head = new Node(0, 0);
    tail = new Node(0, 0);
    head.next = tail;
    head.prev = null;
    tail.next = null;
    tail.prev = head;
    count = 0;
    map = new HashMap<>();
  }

  public static void main(String[] args) {
    LRUCache lRUCache = new LRUCache(2);
    lRUCache.put(1, 1); // cache is {1=1}
    lRUCache.put(2, 2); // cache is {1=1, 2=2}
    lRUCache.get(1);    // return 1
    lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    lRUCache.get(2);    // returns -1 (not found)
    lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    lRUCache.get(1);    // return -1 (not found)
    lRUCache.get(3);    // return 3
    lRUCache.get(4);    // return 4
    System.out.println(lRUCache);
  }

  private void deleteNode(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  private void addToHead(Node node) {
    node.next = head.next;
    node.next.prev = node;
    node.prev = head;
    head.next = node;
  }

  public int get(int key) {
    if(map.containsKey(key)) {
      Node node = map.get(key);
      deleteNode(node);
      addToHead(node);
      return node.value;
    }
    return -1;

  }

  public void put(int key, int value) {
    Node node;
    if(map.containsKey(key)) {
      node = map.get(key);
      node.value = value;
      deleteNode(node);
      addToHead(node);
    } else {
      node = new Node(key, value);
      map.put(key, node);
      if(count < capacity) {
        addToHead(node);
        count++;
      } else {
        map.remove(tail.prev.key);
        deleteNode(tail.prev);
        addToHead(node);
      }
    }
  }
}

package com.shams.lists;

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

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

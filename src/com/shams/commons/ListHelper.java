package com.shams.commons;

public class ListHelper {

  public static class SLLNode {
    public int val;
    public SLLNode next;

    public SLLNode(int value) {
      this.val = value;
    }
  }

  public static void insertSLLNode(SLLNode cur, int value) {
    if (cur == null) {
      cur = new SLLNode(value);
      return;
    }
    while (cur.next != null) {
      cur = cur.next;
    }
    cur.next = new SLLNode(value);
  }

  public static void printSLL(SLLNode head) {
    if (head == null) {
      return;
    }
    System.out.print(head.val + "->");
    printSLL(head.next);
    System.out.println();
  }

  public static class DLLNode {
    public int val;
    public DLLNode next;
    public DLLNode prev;

    public DLLNode(int value) {
      this.val = value;
    }
  }

  public static void insertDLLNode(DLLNode head, int val) {
    DLLNode prev = null, cur = head;
    if (cur == null) {
      cur = new DLLNode(val);
      return;
    }
    while (cur.next != null) {
      prev = cur.next;
      cur = cur.next;
    }
    cur.next = new DLLNode(val);
    cur.prev = prev;
  }

  public static void printDLL(DLLNode head) {
    if (head == null) {
      return;
    }
    System.out.print(head.val + "->");
    printDLL(head.next);
    System.out.println();
  }
}

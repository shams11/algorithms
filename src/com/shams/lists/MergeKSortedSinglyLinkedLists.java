package com.shams.lists;

/**
 * Reference : https://leetcode.com/problems/merge-k-sorted-lists/
 * https://www.geeksforgeeks.org/merge-k-sorted-linked-lists/
 */
public class MergeKSortedSinglyLinkedLists {

  public static class Node {
    int val;
    Node next;
    Node(int val) {
      this.val = val;
    }
  }

  public static void main(String[] args) {
    int k = 3;
    Node[] lists = new Node[k];

    // list 1
    lists[0] = new Node(1);
    lists[0].next = new Node(3);
    lists[0].next.next = new Node(5);
    lists[0].next.next.next = new Node(7);

    // list 2
    lists[1] = new Node(2);
    lists[1].next = new Node(4);
    lists[1].next.next = new Node(6);
    lists[1].next.next.next = new Node(8);

    // list 3
    lists[2] = new Node(0);
    lists[2].next = new Node(9);
    lists[2].next.next = new Node(10);
    lists[2].next.next.next = new Node(11);

    Node head = mergeKLists(lists, 0, k - 1);
    // expected output : 0 1 2 3 4 5 6 7 8 9 10 11
    printList(head);
  }

  private static void printList(Node head) {
    if(head == null)
      return;
    System.out.print(head.val + "->");
    printList(head.next);
  }

  private static Node mergeKLists(Node[] lists, int start, int end) {
    if (start == end) {
      return lists[end]; // or lists[start]
    }
    int middle = (start + end) / 2;
    Node leftList = mergeKLists(lists, start, middle);
    Node rightList = mergeKLists(lists, middle + 1, end);
    return sortedMerge(leftList, rightList);
  }

  private static Node sortedMerge(Node list1, Node list2) {
    if (list1 == null)
      return list2;
    if (list2 == null)
      return list1;
    if (list1.val < list2.val) {
      list1.next = sortedMerge(list1.next, list2);
      return list1;
    } else {
      list2.next = sortedMerge(list2.next, list1);
      return list2;
    }
  }
}

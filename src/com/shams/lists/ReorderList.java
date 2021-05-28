/**
 * https://leetcode.com/problems/reorder-list/
 * https://www.youtube.com/watch?v=xRYPjDMSUFw&ab_channel=NickWhiteNickWhite
 */

package com.shams.lists;

public class ReorderList {
  public static void main(String[] args) {

    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    reorderList(head);
    printList(head);

  }

  private static void printList(ListNode head) {
    if (head == null) {
      return;
    }
    System.out.print(head.val + " ");
    printList(head.next);
  }

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
    }
  }

  public static void reorderList(ListNode head) {
    if (head == null || head.next == null) {
      return;
    }
    ListNode prev = null;
    ListNode l1 = head;
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }

    prev.next = null;
    ListNode l2 = reverse(slow);
    merge(l1, l2);
  }

  private static void merge(ListNode l1, ListNode l2) {
    while (l1 != null) {
      ListNode l1NextNode = l1.next;
      ListNode l2NextNode = l2.next;
      l1.next = l2;
      if (l1NextNode == null) {
        break;
      }
      l2.next = l1NextNode;
      l1 = l1NextNode;
      l2 = l2NextNode;
    }
  }

  static ListNode reverse(ListNode first) {
    ListNode temp, prev = null;
    while (first != null) {
      temp = first;
      first = first.next;
      temp.next = prev;
      prev = temp;
    }
    return prev;
  }
}

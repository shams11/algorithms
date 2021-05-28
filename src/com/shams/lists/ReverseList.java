/**
 * https://leetcode.com/problems/reverse-linked-list/submissions/
 */

package com.shams.lists;

public class ReverseList {

  public static class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
      this.val = val;
    }
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head = reverseList(head);
    printList(head);
  }

  private static void printList(ListNode head) {
    if (head == null) {
      return;
    }
    System.out.print(head.val + " ");
    printList(head.next);
  }

  public static ListNode reverseList(ListNode head) {
    if (head == null) {
      return head;
    }
    ListNode temp, prev = null;
    while (head != null) {
      temp = head;
      head = head.next;
      temp.next = prev;
      prev = temp;
    }
    return prev;
  }
}

/**
 * https://leetcode.com/problems/odd-even-linked-list/
 * https://www.youtube.com/watch?v=C_LA6SOwVTM&ab_channel=NickWhiteNickWhiteVerified
 */

package com.shams.lists;

public class OddEvenList {

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
    ListNode result = oddEvenList(head);
    printList(result);
  }

  private static void printList(ListNode head) {
    if (head == null) {
      return;
    }
    System.out.print(head.val + " ");
    printList(head.next);
  }

  public static ListNode oddEvenList(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode odd = head;
    ListNode even = head.next;
    ListNode evenHead = even;
    while (even != null && even.next != null) {
      odd.next = even.next;
      odd = odd.next;
      even.next = odd.next;
      even = even.next;
    }
    odd.next = evenHead;
    return head;
  }
}

/**
 * https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
 */

package com.shams.lists;

public class SwapNodes {

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
    int k = 2;
    head = swapNodes(head, k);
    printList(head);
  }

  private static void printList(ListNode head) {
    if (head == null) {
      return;
    }
    System.out.print(head.val + " ");
    printList(head.next);
  }

  public static ListNode swapNodes(ListNode head, int k) {
    ListNode slow = head, fast = head;
    ListNode first, second;

    for (int i = 0; i < k - 1; i++) {
      fast = fast.next;
    }
    first = fast;
    while (fast.next != null) {
      slow = slow.next;
      fast = fast.next;
    }
    second = slow;
    int temp = first.val;
    first.val = second.val;
    second.val = temp;
    return head;
  }
}

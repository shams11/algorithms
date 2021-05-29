/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */

package com.shams.lists;

public class ReverseListII {

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

  /*  ListNode head = new ListNode(3);
    head.next = new ListNode(5);*/
    // Output : 5 -> 3
    head = reverseBetween(head, 2, 4);
    printList(head);
  }

  private static void printList(ListNode head) {
    if (head == null) {
      return;
    }
    System.out.print(head.val + " ");
    printList(head.next);
  }


  public static ListNode reverseBetween(ListNode head, int left, int right) {
    if(head == null || (left == right)) {
      return head;
    }
    ListNode prevOfLeft = null, leftP = head, rightP = head, first = head;
    while(left > 1) {
      prevOfLeft = leftP;
      leftP = leftP.next;
      left--;
    }

    while(right > 1) {
      rightP = rightP.next;
      right--;
    }
    if(prevOfLeft == null) {
      head = reverse(leftP, rightP);
      return head;
    }
    prevOfLeft.next = reverse(leftP, rightP);
    return head;
  }

  private static ListNode reverse(ListNode left, ListNode right) {

    ListNode prev = null, temp = null, first = left, rightNext = right.next;
    while(first != null && first != rightNext) {
      temp = first;
      first = first.next;
      temp.next = prev;
      prev = temp;
    }
    left.next = rightNext;
    return prev;
  }
}

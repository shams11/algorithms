/**
 * https://leetcode.com/problems/add-two-numbers/
 * https://www.youtube.com/watch?v=gcpmY8RXCR0&ab_channel=MichaelMuinos
 */

package com.shams.lists;

public class Add2Lists {

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
    }
  }

  public static void main(String[] args) {

    ListNode l1 = new ListNode(9);
    l1.next = new ListNode(9);
    l1.next.next = new ListNode(9);
    l1.next.next.next = new ListNode(9);
    l1.next.next.next.next = new ListNode(9);
    l1.next.next.next.next.next = new ListNode(9);
    l1.next.next.next.next.next.next = new ListNode(9);

    ListNode l2 = new ListNode(9);
    l2.next = new ListNode(9);
    l2.next.next = new ListNode(9);
    l2.next.next.next = new ListNode(9);

    ListNode head = addTwoNumbers(l1, l2);
    printList(head);
    // Output: [8,9,9,9,0,0,0,1]
  }

  private static void printList(ListNode head) {
    if (head == null) {
      return;
    }
    System.out.print(head.val + " ");
    printList(head.next);
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    int carry = 0;
    ListNode result = new ListNode(-1);
    ListNode cur = result;
    while (l1 != null || l2 != null) {
      int sum = 0;
      if (l1 == null) {
        sum = l2.val + carry;
        l2 = l2.next;
      } else if (l2 == null) {
        sum = l1.val + carry;
        l1 = l1.next;
      } else {
        sum = l1.val + l2.val + carry;
        l1 = l1.next;
        l2 = l2.next;
      }
      int num = sum % 10;
      carry = sum / 10;
      cur.next = new ListNode(num);
      cur = cur.next;
    }
    if (carry > 0) {
      cur.next = new ListNode(carry);
    }
    return result.next;
  }
}

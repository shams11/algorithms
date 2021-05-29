/**
 * https://leetcode.com/problems/linked-list-cycle/
 */

package com.shams.lists;

public class ListCycle {

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
    }
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(3);
    head.next = new ListNode(5);
    head.next.next = head;
    System.out.println(hasCycle(head));
  }

  public static boolean hasCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }
}

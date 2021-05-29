/**
 * https://leetcode.com/problems/palindrome-linked-list/
 */

package com.shams.lists;

public class PalindromeList {

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
    head.next.next.next = new ListNode(2);
    head.next.next.next.next = new ListNode(1);
    System.out.println(isPalindrome(head));

  }

  private static void printList(ListNode head) {
    if (head == null) {
      return;
    }
    System.out.print(head.val + " ");
    printList(head.next);
  }

  public static boolean isPalindrome(ListNode head) {
    ListNode prev = null;
    ListNode slow = head;
    ListNode fast = head;
    ListNode l1 = head;
    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    if (prev != null) {
      prev.next = null;
    }
    ListNode l2 = reverse(slow);
    while (l1 != null && l2 != null) {
      if (l1.val != l2.val) {
        return false;
      }
      l1 = l1.next;
      l2 = l2.next;
    }
    return true;
  }

  static ListNode reverse(ListNode first) {
    ListNode prev = null, temp;
    while (first != null) {
      temp = first;
      first = first.next;
      temp.next = prev;
      prev = temp;
    }
    return prev;
  }
}

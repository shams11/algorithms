/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * https://www.youtube.com/watch?v=jTWEmztptCQ&ab_channel=CodingwithConnerCodingwithConner
 * */
package com.shams.lists;

public class ReverseNodesInKGroup {
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head = reverseKGroup(head, 2);
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
  public static ListNode reverseKGroup(ListNode head, int k) {
    if(head == null || k == 1) {
      return head;
    }
    ListNode root = new ListNode(-1);
    ListNode cur = head;
    ListNode prev = root;
    ListNode tail;

    while(cur != null) {
      tail = cur;
      int i = 0;
      while(cur != null && i < k) {
        i++;
        cur = cur.next;
      }
      if(i != k) {
        prev.next = tail;
      } else {
        prev.next = reverse(tail, k);
        prev = tail;
      }
    }
    return root.next;
  }

  private static ListNode reverse(ListNode first, int k) {
    ListNode temp, prev = null;
    while(first != null && k-- > 0) {
      temp = first;
      first = first.next;
      temp.next = prev;
      prev = temp;
    }
    return prev;
  }
}

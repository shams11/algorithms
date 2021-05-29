/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * */
package com.shams.lists;

public class IntersectionOf2Lists {

  public static class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
      this.val = val;
    }
  }
  public static void main(String[] args) {
    ListNode head1 = new ListNode(2);
    head1.next = new ListNode(6);
    head1.next.next = new ListNode(4);

    ListNode head2 = new ListNode(1);
    head2.next = new ListNode(5);
    ListNode result = getIntersectionNode(head1, head2);
    System.out.println(result.val);
    //Output : NPE
  }

  public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode l1= headA, l2 = headB;
    while(l1 != l2) {
      if(l1 == null) {
        l1 = headB;
      } else {
        l1 = l1.next;
      }

      if(l2 == null) {
        l2 = headA;
      } else {
        l2 = l2.next;
      }
    }
    return l1;
  }
}

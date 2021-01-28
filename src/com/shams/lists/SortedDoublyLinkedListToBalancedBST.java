/**
 * https://www.geeksforgeeks.org/sorted-linked-list-to-balanced-bst/
 * */
package com.shams.lists;

import com.shams.commons.ListHelper;
import com.shams.commons.UtilityHelper;

public class SortedDoublyLinkedListToBalancedBST {
  static ListHelper.DLLNode head = null;

  public static void main(String[] args) {
    head = new ListHelper.DLLNode(1);
    ListHelper.insertDLLNode(head, 2);
    ListHelper.insertDLLNode(head, 3);
    ListHelper.insertDLLNode(head, 4);
    ListHelper.insertDLLNode(head, 5);
    ListHelper.insertDLLNode(head, 6);
    ListHelper.insertDLLNode(head, 7);

    ListHelper.printDLL(head);
    UtilityHelper.Node root = sortedListToBST1();
    UtilityHelper.inorder(root);
  }

  private static UtilityHelper.Node sortedListToBST1() {
    int count = getListSize(head);
    return sortedListToBSTRecur1(count);
  }

  private static UtilityHelper.Node sortedListToBSTRecur1(int n) {
    if(n == 0) {
      return null;
    }
    UtilityHelper.Node left = sortedListToBSTRecur1(n/2);
    UtilityHelper.Node root = new UtilityHelper.Node(head.val);
    if(left != null) {
      root.left = left;
    }
    head = head.next;
    root.right = sortedListToBSTRecur1(n - n/2 - 1);
    return root;
  }

  private static int getListSize(ListHelper.DLLNode head) {
    ListHelper.DLLNode cur = head;
    int count = 0;
    if (cur == null) {
      return 0;
    }
    while (cur != null) {
      count++;
      cur = cur.next;
    }
    return count;
  }

  static UtilityHelper.Node sortedListToBST() {
    /*Count the number of nodes in Linked List */
    int n = countNodes(head);

    /* Construct BST */
    return sortedListToBSTRecur(n);
  }

  /* The main function that constructs balanced BST and
     returns root of it.
     n  --> No. of nodes in the Doubly Linked List */
  static UtilityHelper.Node sortedListToBSTRecur(int n) {
    /* Base Case */
    if (n <= 0)
      return null;

    /* Recursively construct the left subtree */
    UtilityHelper.Node left = sortedListToBSTRecur(n / 2);

        /* head_ref now refers to middle node,
           make middle node as root of BST*/
    UtilityHelper.Node root = new UtilityHelper.Node(head.val);

    // Set pointer to left subtree
    root.left = left;

        /* Change head pointer of Linked List for parent
           recursive calls */
    head = head.next;

        /* Recursively construct the right subtree and link it
           with root. The number of nodes in right subtree  is
           total nodes - nodes in left subtree - 1 (for root) */
    root.right = sortedListToBSTRecur(n - n / 2 - 1);

    return root;
  }

  /* UTILITY FUNCTIONS */
    /* A utility function that returns count of nodes in a
       given Linked List */
  static int countNodes(ListHelper.DLLNode head) {
    int count = 0;
    ListHelper.DLLNode temp = head;
    while (temp != null) {
      temp = temp.next;
      count++;
    }
    return count;
  }
}

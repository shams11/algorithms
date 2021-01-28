/**
 * https://www.geeksforgeeks.org/convert-a-given-binary-tree-to-doubly-linked-list-set-4/
 * 28-jan-2021
 * @author - shams
 * */

package com.shams.lists;

import com.shams.commons.UtilityHelper;

public class ConvertBinaryTreeToDLL {

  static UtilityHelper.Node head = null;
  public static void main(String[] args) {
    UtilityHelper.Node root = new UtilityHelper.Node(10);
    root.left = new UtilityHelper.Node(12);
    root.right = new UtilityHelper.Node(15);
    root.left.left = new UtilityHelper.Node(25);
    root.left.right = new UtilityHelper.Node(30);
    root.right.left = new UtilityHelper.Node(36);
    UtilityHelper.inorder(root);
    System.out.println();
    convertBinaryTreeToDLL(root);
    while(head != null) {
      System.out.println(head.val);
      head = head.right;
    }
  }

  private static void convertBinaryTreeToDLL(UtilityHelper.Node root) {
    if(root == null) {
      return;
    }
    convertBinaryTreeToDLL(root.right);
    root.right = head;
    if(head != null) {
      head.left = root;
    }
    head = root;
    convertBinaryTreeToDLL(root.left);
  }
}

/**
 * https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
 * */
package com.shams.trees.binarytrees;

import com.shams.commons.UtilityHelper;
import java.util.Stack;

public class InorderIterative {

  public static void main(String[] args) {
    UtilityHelper.Node root = new UtilityHelper.Node(1);
    root.left = new UtilityHelper.Node(2);
    root.right = new UtilityHelper.Node(3);
    root.left.left = new UtilityHelper.Node(4);
    root.left.right = new UtilityHelper.Node(5);
    inorderIterative(root);
  }

  private static void inorderIterative(UtilityHelper.Node root) {

    if(root == null) {
      System.out.println("Empty tree");
      return;
    }
    Stack<UtilityHelper.Node> s = new Stack<>();
    while(root != null || !s.isEmpty()) {

      while(root != null) {
        s.push(root);
        root = root.left;
      }
      root = s.pop();
      System.out.print(root.val + " ");
      root = root.right;
    }
  }
}

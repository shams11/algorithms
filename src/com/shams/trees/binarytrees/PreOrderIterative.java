/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 * https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45551/Preorder-Inorder-and-Postorder-Iteratively-Summarization
 * */
package com.shams.trees.binarytrees;

import com.shams.commons.UtilityHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderIterative {
  public static void main(String[] args) {
    UtilityHelper.Node root = new UtilityHelper.Node(1);
    root.left = new UtilityHelper.Node(2);
    root.right = new UtilityHelper.Node(3);
    root.left.left = new UtilityHelper.Node(4);
    root.left.right = new UtilityHelper.Node(5);
    root.right.left = new UtilityHelper.Node(6);
    root.right.right = new UtilityHelper.Node(7);
    System.out.println(preIterative(root));
  }

  private static List<Integer> preIterative(UtilityHelper.Node root) {
    if (root == null) {
      return List.of();
    }
    List<Integer> result = new ArrayList<>();
    Stack<UtilityHelper.Node> s = new Stack<>();
    while (!s.isEmpty() || root != null) {
      if (root != null) {
        s.push(root);
        result.add(root.val);
        root = root.left;
      } else {
        root = s.pop();
        root = root.right;
      }
    }
    return result;
  }
}

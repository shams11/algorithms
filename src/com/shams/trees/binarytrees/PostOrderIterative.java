/**
 * https://www.youtube.com/watch?v=sMI4RBEZyZ4&ab_channel=KevinNaughtonJr.KevinNaughtonJr.
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45551/Preorder-Inorder-and-Postorder-Iteratively-Summarization
 */

package com.shams.trees.binarytrees;

import com.shams.commons.UtilityHelper;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostOrderIterative {
  public static void main(String[] args) {
    UtilityHelper.Node root = new UtilityHelper.Node(1);
    root.left = new UtilityHelper.Node(2);
    root.right = new UtilityHelper.Node(3);
    root.left.left = new UtilityHelper.Node(4);
    root.left.right = new UtilityHelper.Node(5);
    root.right.left = new UtilityHelper.Node(6);
    root.right.right = new UtilityHelper.Node(7);
    System.out.println(postOrderIterative(root));
  }

  private static List<Integer> postOrderIterative(UtilityHelper.Node root) {
    if (root == null) {
      return List.of();
    }
    LinkedList<Integer> result = new LinkedList<>();
    Stack<UtilityHelper.Node> s = new Stack<>();
    s.push(root);
    while (!s.isEmpty()) {
      root = s.pop();
      result.addFirst(root.val);
      if (root.left != null) {
        s.push(root.left);
      }
      if (root.right != null) {
        s.push(root.right);
      }
    }
    return result;
  }
}

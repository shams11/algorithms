/**
 * https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
 * https://leetcode.com/problems/binary-tree-postorder-traversal/submissions/
 * https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45551/Preorder-Inorder-and-Postorder-Iteratively-Summarization
 */

package com.shams.trees.binarytrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderIterative {

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    List<Node> result = inorderIterative(root);
    for (Node node : result) {
      System.out.print(node.val + " ");
    }

  }

  public static class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
      this.val = val;
    }
  }

  private static List<Node> inorderIterative(Node root) {
    if (root == null) {
      return List.of();
    }
    Stack<Node> stack = new Stack<>();
    List<Node> result = new ArrayList<>();
    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        root = stack.pop();
        result.add(root);
        root = root.right;
      }
    }
    return result;
  }
}

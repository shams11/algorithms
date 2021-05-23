/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * https://www.youtube.com/watch?v=78jJYILq0Jc&list=PLasFRNAqNxSEzsU1sz-hAl3pDxgcwhEMD&index=5&ab_channel=HackerHeap
 */

package com.shams.trees.binarytrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerializeAndDeserializeBinaryTree {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(5);
    root.left.left = new TreeNode(6);
    root.left.right = new TreeNode(2);
    root.left.right.left = new TreeNode(7);
    root.left.right.right = new TreeNode(4);
    root.right = new TreeNode(1);
    root.right.left = new TreeNode(0);
    root.right.right = new TreeNode(8);
    String s = serialize(root);
    System.out.println(s);
    TreeNode node = deserialize(s);
    printTree(node);
  }

  private static void printTree(TreeNode root) {
    if (root == null) return;
    printTree(root.left);
    System.out.print(root.val + " ");
    printTree(root.right);
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  // Encodes a tree to a single string.
  public static String serialize(TreeNode root) {
    if (root == null) {
      return "null,";
    }
    String serializedString = "";
    serializedString += Integer.toString(root.val) + ",";
    serializedString += serialize(root.left);
    serializedString += serialize(root.right);
    return serializedString;
  }

  // Decodes your encoded data to tree.
  public static TreeNode deserialize(String data) {
    System.out.println(data);
    String[] nodeArray = data.split(",");
    List<String> nodeList = new ArrayList<>(Arrays.asList(nodeArray));
    return deserializeHelper(nodeList);
  }

  static TreeNode deserializeHelper(List<String> nodeList) {
    String nodeVal = nodeList.get(0);
    nodeList.remove(0);
    if (nodeVal.equals("null")) {
      return null;
    }
    TreeNode node = new TreeNode(Integer.parseInt(nodeVal));
    node.left = deserializeHelper(nodeList);
    node.right = deserializeHelper(nodeList);
    return node;
  }
}

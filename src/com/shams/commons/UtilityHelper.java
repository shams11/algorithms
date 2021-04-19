package com.shams.commons;

import java.util.ArrayList;
import java.util.List;

public class UtilityHelper {

  public static class Node {
    public int val;
    public Node left;
    public Node right;

    public Node(int value) {
      this.val = value;
    }
  }

  public static void swap(int[] a, int j, int i) {
    int temp = a[j];
    a[j] = a[i];
    a[i] = temp;
  }

  public static void printArray(int[] a) {
    for (int value : a) {
      System.out.print(value + " ");
    }
    System.out.println();
  }

  public static void inorder(Node node) {
    if (node == null) {
      return;
    }
    inorder(node.left);
    System.out.print(node.val + "  ");
    inorder(node.right);
  }

  public static void insertNodeInBST(Node root, int value) {
    if (root == null) {
      return;
    }
    if (value < root.val) {
      if (root.left == null) {
        root.left = new Node(value);
      } else {
        insertNodeInBST(root.left, value);
      }
    } else {
      if (root.right == null) {
        root.right = new Node(value);
      } else {
        insertNodeInBST(root.right, value);
      }
    }
  }

  public static List<Integer> getNeighbours(Integer s, int[][] m) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < m[0].length; i++) {
      if (m[s][i] == 1) {
        list.add(i);
      }
    }
    return list;
  }
}

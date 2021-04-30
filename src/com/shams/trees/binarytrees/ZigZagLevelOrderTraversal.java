/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * https://www.youtube.com/watch?v=XZnWETlZZ14&ab_channel=KevinNaughtonJr.
 * */
package com.shams.trees.binarytrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrderTraversal {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
      this.val = val;
    }
  }

  public static void main(String[] args) {
  TreeNode root = new TreeNode(6);
    root.left = new TreeNode(7);
    root.right = new TreeNode(8);
    root.left.left = new TreeNode(2);
    root.right.right = new TreeNode(5);
    // Output : [ [6], [8,7], [2, 5] ]
    System.out.println(zigzagLevelOrder(root));
  }

  public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if(root == null) {
      return result;
    }
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    boolean flag = true;
    while(!q.isEmpty()) {
      int n = q.size();
      List<Integer> curLevelList = new ArrayList<>();
      for(int i = 0; i < n; i++) {
        TreeNode cur = q.poll();
        curLevelList.add(cur.val);
        if(cur.right != null) {
          q.add(cur.right);
        }
        if(cur.left != null) {
          q.add(cur.left);
        }
      }
      if(flag) {
        Collections.reverse(curLevelList);
      }
      result.add(curLevelList);
      flag = !flag;

    }
    return result;
  }
}

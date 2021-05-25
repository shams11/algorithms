/**
 * https://leetcode.com/problems/find-duplicate-subtrees/submissions/
 * https://www.youtube.com/watch?v=nxHBg7hm0rs
 */

package com.shams.trees.binarytrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubTrees {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(4);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(2);
    root.right.left.left = new TreeNode(4);
    root.right.right = new TreeNode(4);
    List<TreeNode> list = findDuplicateSubtrees(root);
    for(TreeNode node : list) {
      printTree(node);
    }
  }

  private static void printTree(TreeNode root) {
    if (root == null) return;
    printTree(root.left);
    System.out.print(root.val + " ");
    printTree(root.right);
  }


  public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> list = new ArrayList<>();
    findDuplicate(root, map, list);
    System.out.println(map);
    return list;
  }

  private static String findDuplicate(
      TreeNode root, Map<String, Integer> map, List<TreeNode> list) {

    if(root == null) {
      return "x";
    }
    String left = findDuplicate(root.left, map, list);
    String right = findDuplicate(root.right, map, list);
    String key = root.val + "|" + left  + "|" + right;
    map.put(key, map.getOrDefault(key, 0) + 1);
    if(map.get(key) == 2) {
      list.add(root);
    }
    return key;
  }

  public static List<TreeNode> findDuplicateSubtrees1(TreeNode root) {
    Map<Integer, TreeNode> nodeTreeNodeMap = new HashMap<>();
    List<TreeNode> dupSubTreesNodes = new ArrayList<>();
    populateMap(root.left, nodeTreeNodeMap);
    traverseRightSubTree(root.right, nodeTreeNodeMap, dupSubTreesNodes);
    return dupSubTreesNodes;
  }

  private static void traverseRightSubTree(
      TreeNode root, Map<Integer, TreeNode> map, List<TreeNode> dupSubTreesNodes) {
    if (root == null) {
      return;
    }
    if (map.containsKey(root.val)) {
      if (isStructureSame(root, map.get(root.val))) {
        dupSubTreesNodes.add(root);
        return;
      }
    }
    traverseRightSubTree(root.left, map, dupSubTreesNodes);
    traverseRightSubTree(root.right, map, dupSubTreesNodes);
  }

  private static boolean isStructureSame(TreeNode root, TreeNode node) {
    if (root == null && node == null) {
      return true;
    }
    if (root != null && node != null && root.val == node.val) {
      return isStructureSame(root.left, node.left) && isStructureSame(root.right, node.right);
    }
    return false;
  }

  private static void populateMap(TreeNode root, Map<Integer, TreeNode> map) {
    if (root == null) {
      return;
    }
    if (!map.containsKey(root.val)) {
      map.put(root.val, root);
    }
    populateMap(root.left, map);
    populateMap(root.right, map);
  }
}

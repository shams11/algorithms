/**
 * https://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
 * https://www.youtube.com/watch?v=g1R3yEtHT8E&ab_channel=WorkWithGooglerWorkWithGoogler
 */

package com.shams.trees.binarytrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class KDistanceNodes {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

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

    int k = 2;
    System.out.println(distanceK(root, root.left, k));

  }

  private static void dfs(
      TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> nodeParentMap) {

    if(node == null) {
      return;
    }
    if(parent != null) {
      nodeParentMap.put(node, parent);
    }
    dfs(node.left, node, nodeParentMap);
    dfs(node.right, node, nodeParentMap);
  }

  private static void addNodeToQueue(TreeNode node, Queue<TreeNode> q, Set<TreeNode> visited) {
    if(node == null || visited.contains(node)) {
      return;
    }
    visited.add(node);
    q.add(node);
  }

  public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

    List<Integer> result = new ArrayList<>();
    Map<TreeNode, TreeNode> nodeParentMap = new HashMap<>();
    dfs(root, null, nodeParentMap);

    // BFS
    Queue<TreeNode> q = new LinkedList<>();
    Set<TreeNode> visited = new HashSet<>();
    q.add(target);
    visited.add(target);
    int distance = 0;
    while(!q.isEmpty()) {
      int size = q.size();
      for(int i = 0; i < size; i++) {
        TreeNode node = q.poll();
        if(distance == k) {
          result.add(node.val);
        }
        addNodeToQueue(node.left, q, visited);
        addNodeToQueue(node.right, q, visited);
        addNodeToQueue(nodeParentMap.getOrDefault(node, null), q, visited);
      }
      ++distance;
      if(distance > k) {
        break;
      }
    }
    return result;
  }
}

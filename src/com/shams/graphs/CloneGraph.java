/***
 * https://leetcode.com/problems/clone-graph/submissions/
 * https://www.youtube.com/watch?v=e5tNvT1iUXs&ab_channel=MichaelMuinos
 * */
package com.shams.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
  public static void main(String[] args) {

  }

  public Node cloneGraph(Node node) {
    if(node == null) return null;
    Map<Integer, Node> map = new HashMap<>();
    return cloneGraphUtil(node, map);
  }

  private Node cloneGraphUtil(Node node, Map<Integer, Node> map) {
    if(map.containsKey(node.val)) return map.get(node.val);

    Node newNode = new Node(node.val);
    map.put(newNode.val, newNode);
    for(Node n : node.neighbors) {
      newNode.neighbors.add(cloneGraphUtil(n, map));
    }
    return newNode;
  }

  class Node {
    public int val;
    public List<Node> neighbors;

    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<>();
    }
  }
}

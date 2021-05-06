package com.shams.graphs;

public class DisjointSetWithPathCompression {

  public static class Node {
    int parent;
    int rank;

    public Node(int parent, int rank) {
      this.parent = parent;
      this.rank = rank;
    }
  }

  static Node[] nodes;

  public static void main(String[] args) {

    int v = 5;
    nodes = new Node[v];
    int[][] edges = {
        {0, 1},
        {2, 3},
        {1, 2},
        {0, 4},
        {4, 3}
    };
    System.out.println(disjointSet(edges, v));

  }

  private static boolean disjointSet(int[][] edges, int v) {
    for (int i = 0; i < v; i++) {
      nodes[i] = new Node(-1, 0);
    }
    if (isCycle(edges)) {
      return true;
    }
    return false;
  }

  private static boolean isCycle(int[][] edges) {

    for (int[] e : edges) {
      int fromParent = find(e[0]);
      int toParent = find(e[1]);

      if (fromParent == toParent) {
        return true;
      }
      union(fromParent, toParent);
    }
    return false;
  }

  private static int find(int v) {
    if (nodes[v].parent == -1) {
      return v;
    }
    return nodes[v].parent = find(nodes[v].parent);
  }

  private static void union(int fromP, int toP) {
    if (nodes[fromP].rank > nodes[toP].rank) {
      nodes[toP].parent = fromP;
    } else if (nodes[toP].rank > nodes[fromP].rank) {
      nodes[fromP].parent = toP;
    } else {
      // both nodes has equal rank
      // select any nodes a parent
      nodes[fromP].parent = toP;
      nodes[toP].rank++;
    }
  }
}

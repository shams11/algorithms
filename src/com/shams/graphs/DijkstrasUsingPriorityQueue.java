/**
 * https://algorithms.tutorialhorizon.com/dijkstras-shortest-path-algorithm-spt-adjacency-list-and-priority-queue-java-implementation/
 * https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-in-java-using-priorityqueue/
 */

package com.shams.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstrasUsingPriorityQueue {

  static class Node {
    int node;
    int cost;

    public Node(int node, int cost) {
      this.node = node;
      this.cost = cost;
    }
  }

  static Map<Integer, List<Node>> map = new HashMap<>();

  public static void main(String[] args) {
    int v = 9;
    int source = 0;
    dijkstras(source, v);
  }

  private static void buildGraph(int v) {
    for (int i = 0; i < v; i++) {
      if (!map.containsKey(i)) {
        map.put(i, new ArrayList<>());
      }
    }
  }

  static PriorityQueue<Node> pq = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost);
  static boolean[] visited;
  static int[] dist;

  private static void dijkstras(int src, int v) {
    buildGraph(v);
    addEdges();
    visited = new boolean[v];
    dist = new int[v];
    // initialize distance with max value
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;
    bfs(src);
    printDijkstra(dist, src, v);
  }

  private static void bfs(int src) {
    pq.add(new Node(src, 0));
    visited[src] = true;
    while (!pq.isEmpty()) {
      Node cur = pq.poll();
      List<Node> neighborNodes = map.get(cur.node);
      for (Node neighborEdge : neighborNodes) {
        if (!visited[neighborEdge.node]) {
          int newCost = dist[cur.node] + neighborEdge.cost;
          if (newCost < dist[neighborEdge.node]) {
            dist[neighborEdge.node] = newCost;
            pq.add(new Node(neighborEdge.node, newCost));
          }
        }
      }
      visited[cur.node] = true;
    }
  }

  public static void printDijkstra(int[] distance, int sourceVertex, int vertices) {
    System.out.println("Dijkstra Algorithm: (Adjacency List + Priority Queue)");
    for (int i = 0; i < vertices; i++) {
      System.out.println("Source Vertex: " + sourceVertex + " to vertex " + +i +
          " distance: " + distance[i]);
    }
  }

  private static void addEdges() {
    map.get(0).add(new Node(1, 4));
    map.get(0).add(new Node(7, 8));
    map.get(1).add(new Node(0, 4));
    map.get(1).add(new Node(2, 8));
    map.get(1).add(new Node(7, 11));
    map.get(2).add(new Node(3, 7));
    map.get(2).add(new Node(1, 8));
    map.get(2).add(new Node(8, 2));
    map.get(2).add(new Node(5, 4));
    map.get(3).add(new Node(4, 9));
    map.get(3).add(new Node(5, 14));
    map.get(3).add(new Node(2, 7));
    map.get(4).add(new Node(3, 9));
    map.get(4).add(new Node(5, 10));
    map.get(5).add(new Node(4, 10));
    map.get(5).add(new Node(3, 14));
    map.get(5).add(new Node(2, 4));
    map.get(5).add(new Node(6, 2));
    map.get(6).add(new Node(5, 2));
    map.get(6).add(new Node(8, 6));
    map.get(6).add(new Node(7, 1));
    map.get(7).add(new Node(6, 1));
    map.get(7).add(new Node(8, 7));
    map.get(7).add(new Node(0, 8));
    map.get(7).add(new Node(1, 11));
    map.get(8).add(new Node(6, 6));
    map.get(8).add(new Node(2, 2));
    map.get(8).add(new Node(7, 7));

//    map.get(0).add(new Node(1, 1));
//    map.get(0).add(new Node(2, 4));
//    map.get(1).add(new Node(0, 1));
//    map.get(1).add(new Node(2, 4));
//    map.get(1).add(new Node(4, 7));
//    map.get(1).add(new Node(3, 2));
//    map.get(2).add(new Node(0, 4));
//    map.get(2).add(new Node(1, 4));
//    map.get(2).add(new Node(3, 3));
//    map.get(2).add(new Node(4, 5));
//    map.get(3).add(new Node(2, 3));
//    map.get(3).add(new Node(1, 2));
//    map.get(3).add(new Node(4, 4));
//    map.get(3).add(new Node(5, 6));
//    map.get(4).add(new Node(1, 7));
//    map.get(4).add(new Node(5, 7));
//    map.get(4).add(new Node(3, 4));
//    map.get(4).add(new Node(2, 5));
//    map.get(5).add(new Node(4, 7));
//    map.get(5).add(new Node(3, 6));
  }
}

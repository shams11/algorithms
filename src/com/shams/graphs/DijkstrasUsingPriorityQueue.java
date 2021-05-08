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
  public static void main(String[] args) {
    int v = 5;
    int source = 0;
    dijkstras(source, v);
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
    pq.add(new Node(src, 0));
    dist[src] = 0;
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
    }
    printDijkstra(dist, src, v);
  }

  public static void printDijkstra(int[] distance, int sourceVertex, int vertices) {
    System.out.println("Dijkstra Algorithm: (Adjacency List + Priority Queue)");
    for (int i = 0; i < vertices; i++) {
      System.out.println("Source Vertex: " + sourceVertex + " to vertex " + +i +
          " distance: " + distance[i]);
    }
  }

  private static void addEdges() {
    map.get(0).add(new Node(1, 9));
    map.get(0).add(new Node(2, 6));
    map.get(0).add(new Node(3, 5));
    map.get(0).add(new Node(4, 3));
    map.get(2).add(new Node(1, 2));
    map.get(2).add(new Node(3, 4));
  }

  static class Node {
    int node;
    int cost;

    public Node(int node, int cost) {
      this.node = node;
      this.cost = cost;
    }
  }

  static Map<Integer, List<Node>> map = new HashMap<>();

  private static void buildGraph(int v) {
    for (int i = 0; i < v; i++) {
      if (!map.containsKey(i)) {
        map.put(i, new ArrayList<>());
      }
    }
  }
}

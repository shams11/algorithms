/**
 * https://leetcode.com/problems/reconstruct-itinerary/submissions/
 * https://www.youtube.com/watch?v=DXPEHaBOHPE&list=PLasFRNAqNxSEzsU1sz-hAl3pDxgcwhEMD&index=25&ab_channel=HackerHeap
 * */
package com.shams.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary {
  public static void main(String[] args) {

//    List<List<String>> input = List.of(
//        List.of("MUC", "LHR"),
//        List.of("JFK", "MUC"),
//        List.of("SFO", "SJC"),
//        List.of("LHR", "SFO")
//    );

    List<List<String>> input = List.of(
        List.of("JFK", "SFO"),
        List.of("JFK", "ATL"),
        List.of("SFO", "ATL"),
        List.of("ATL", "JFK"),
        List.of("ATL", "SFO")
    );
    // Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
    System.out.println(findItinerary(input));
  }

  static Map<String, PriorityQueue<String>> graph = new HashMap<>();
  static LinkedList<String> list = new LinkedList<>();
  public static List<String> findItinerary(List<List<String>> tickets) {
    if (tickets.size() == 1) {
      return tickets.get(0);
    }
    
    for (List<String> ticket : tickets) {
      String key = ticket.get(0);
      if (!graph.containsKey(key)) {
        graph.put(key, new PriorityQueue<>((e1, e2) -> e1.compareTo(e2)));
      }
      graph.get(key).add(ticket.get(1));
    }
    dfs("JFK");
    return list;
  }

  private static void dfs(String s) {
    PriorityQueue<String> pq = graph.getOrDefault(s, new PriorityQueue<>());
    while(!pq.isEmpty()) {
      dfs(pq.poll());
    }
    list.addFirst(s);
  }
}

/**
 * https://leetcode.com/problems/top-k-frequent-words/
 * https://www.youtube.com/watch?v=cupg2TGIkyM&ab_channel=MichaelMuinos
 */

package com.shams.strings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
  public static void main(String[] args) {

    String[] s = {"i", "love", "leetcode", "i", "love",
        "leetcode", "leetcode", "shams", "shams", "shams", "shams"};
    int k = 2;
    List<String> result = topKFrequent1(s, k);
    System.out.println(result);
  }

  private static List<String> topKFrequent1(String[] words, int k) {
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }
    PriorityQueue<String> pq = new PriorityQueue<>((word1, word2) -> {
      int frequency1 = map.get(word1);
      int frequency2 = map.get(word2);
      if (frequency1 == frequency2) {
        // if frequency is same, then order words alphabetically
        return word2.compareTo(word1);
      }
      // else order by frequency
      return frequency1 - frequency2;
    });
    for (String e : map.keySet()) {
      pq.add(e);
      if (pq.size() > k) {
        pq.poll();
      }
    }
    LinkedList<String> result = new LinkedList<>();
    while (!pq.isEmpty()) {
      result.addFirst(pq.poll());
    }
    return result;
  }
}

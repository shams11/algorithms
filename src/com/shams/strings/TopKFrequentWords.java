/**
 * https://leetcode.com/problems/top-k-frequent-words/
 * https://www.youtube.com/watch?v=-pO5TuSL-Ks
 */

package com.shams.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
  public static void main(String[] args) {

    String[] s = {"i", "love", "leetcode", "i", "love", "leetcode"};
    int k = 2;
    List<String> result = topKFrequent1(s, k);
    System.out.println(result);
  }

  private static List<String> topKFrequent1(String[] words, int k) {
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }
    PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
      @Override
      public int compare(String word1, String word2) {
        int frequency1 = map.get(word1);
        int frequency2 = map.get(word2);
        if (frequency1 == frequency2) {
          return word2.compareTo(word1);
        }
        return frequency1 - frequency2;
      }
    });
    for (Map.Entry<String, Integer> e : map.entrySet()) {
      pq.add(e.getKey());
      if (pq.size() > k) {
        pq.poll();
      }
    }
    List<String> result = new ArrayList<>();
    while (!pq.isEmpty()) {
      result.add(pq.poll());
    }
    Collections.reverse(result);
    return result;
  }

  private static List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> map = new HashMap<String, Integer>();
    List<String> ans = new ArrayList<String>();
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }
    List<String> result = new ArrayList<>(map.keySet());
    System.out.println(result);
    result.sort((word1, word2) -> {
      int comparision = map.get(word1).compareTo(map.get(word2));
      if (comparision == 0) {
        return word1.compareTo(word2);
      }
      return comparision;
    });

    return result.subList(0, k);
  }
}

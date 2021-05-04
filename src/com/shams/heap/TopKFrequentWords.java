package com.shams.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
  public static void main(String[] args) {
    String[] s = {"i", "love", "leetcode", "i", "love", "coding"};
    int k = 2;
    System.out.println(topKFrequent(s, k));
  }

  public static List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> map = new HashMap<>();
    for(String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1 );
    }

    PriorityQueue<String> pq = new PriorityQueue<>((word1, word2) -> {
      int frequency1 = map.get(word1);
      int frequency2 = map.get(word2);
      if(frequency1 == frequency2) {
        return word2.compareTo(word1);
      }
      return frequency1 - frequency2;
    });

    for(String e : map.keySet()) {
      pq.add(e);
      if(pq.size() > k) {
        pq.poll();
      }
    }
    List<String> result = new ArrayList<>();
    while(pq.size() > 0) {
      result.add(pq.poll());
    }
    Collections.reverse(result);
    return result;
  }
}

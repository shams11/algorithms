/**
 * https://leetcode.com/problems/alien-dictionary/
 * https://www.youtube.com/watch?v=LA0X_N-dEsg&ab_channel=happygirlzt
 * https://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/
 */

package com.shams.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AlienDictionary {
  public static void main(String[] args) {

    /**
     * Question
     *
     * There is a new alien language which uses the latin alphabet.
     * However, the order among letters are unknown to you.
     * You receive a list of words from the dictionary,
     * where words are sorted lexicographically by the rules of this new language.
     * Derive the order of letters in this language.
     *
     * For example,
     * Given the following words in dictionary,
     *
     * [
     * "wrt",
     * "wrf",
     * "er",
     * "ett",
     * "rftt"
     * ]
     * The correct order is: "wertf".
     * */

    /***
     * Algorithm
     * 1. Build graph with given words (build map) Map<Character, Set<Character>>
     *    for each character of each word,
     *      map.put(c, new HashSet<>());
     *      | t | f |
     *      | w | e |
     *      | r | t |
     *      | e | r |
     *      | f | <> |
     * 2. dfs and build result string
     * */
    String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
    System.out.println(alienOrder(words));
  }

  static StringBuffer result = new StringBuffer();

  private static String alienOrder(String[] words) {
    if (words == null) return "";
    Map<Character, Set<Character>> map = new HashMap<>();
    buildGraph(words, map);
    System.out.println(map);
    boolean[] visited = new boolean[26];
    System.out.println(" Key set : "  + map.keySet());
    getAlienOrder(map, visited);
    return result.reverse().toString();
  }

  private static void getAlienOrder(Map<Character, Set<Character>> map, boolean[] visited) {
    for (Character c : map.keySet()) {
      if (!visited[c - 'a']) {
        dfs(c, map, visited);
      }
    }
  }

  private static void dfs(Character s, Map<Character, Set<Character>> map, boolean[] visited) {
    visited[s - 'a'] = true;
    for (Character c : map.getOrDefault(s, new HashSet<>())) {
      if (!visited[c - 'a']) {
        dfs(c, map, visited);
      }
    }
    result.append(s);
  }

  private static void buildGraph(
      String[] words, Map<Character, Set<Character>> map) {
    for (String word : words) {
      for (char c : word.toCharArray()) {
        map.putIfAbsent(c, new HashSet<>());
      }
    }

    for (int i = 1; i < words.length; i++) {
      String first = words[i - 1];
      String second = words[i];
      int len = Math.min(first.length(), second.length());
      for (int j = 0; j < len; j++) {
        char out = first.charAt(j);
        char in = second.charAt(j);
        if (out != in) {
          map.get(out).add(in);
          break;
        }
      }
    }
  }
}

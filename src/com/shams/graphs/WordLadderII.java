/**
 * https://leetcode.com/problems/word-ladder-ii/submissions/
 * https://www.youtube.com/watch?v=M9cVl4d0v04
 * */
package com.shams.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
  public static void main(String[] args) {
    String beginWord = "hit", endWord = "cog";
    List<String> wordList = List.of("hot","dot","dog","lot","log");
    System.out.println(findLadders(beginWord, endWord, wordList));
  }

  static public int findLadders(String beginWord, String endWord, List<String> wordList) {
    Set<String> set = new HashSet<>(wordList);
    if(!set.contains(endWord)) {
      return 0;
    }
    Queue<String> q = new LinkedList<>();
    q.add(beginWord);
    int depth = 1;

    while (!q.isEmpty()) {

      int size = q.size();
      for (int i = 0; i < size;  i++) {
        String curWord = q.poll();

        char[] curWordCharArray = curWord.toCharArray();
        for (int j = 0; j < curWordCharArray.length; j++) {
          char originalCharacter = curWordCharArray[j];
          for (char c = 'a'; c <= 'z'; c++) {
            if (c == curWordCharArray[j]) {
              continue;
            }
            curWordCharArray[j] = c;
            String newWord = new String(curWordCharArray);
            if (curWord.equals(endWord)) {
              return depth;
            }
            if (set.contains(newWord)) {
              q.add(newWord);
              set.remove(newWord);
            }
          }
          curWordCharArray[j] = originalCharacter;
        }
      }
      depth++;
    }
    return depth;
  }
}

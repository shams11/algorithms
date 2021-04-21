/***
 * https://leetcode.com/problems/possible-bipartition/submissions/
 * https://www.youtube.com/watch?v=0ACfAqs8mm0&list=PLEJXowNB4kPzByLnnFYNSCoqtFz0VKLk5&index=8&ab_channel=TECHDOSE
 * */
package com.shams.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BipartiteGraph {

  static Queue<Integer> q = new LinkedList<>();

  public static void main(String[] args) {
//    int N = 4;
//    int[][] a = {
//        {1, 2},
//        {1, 3},
//        {2, 4}
//    };
//    Output: true
//    Explanation: group1 [1,4], group2 [2,3]
//
//    int N = 3;
//    int[][] a = {
//        {1, 2},
//        {1, 3},
//        {2, 3}
//    };
//   Output: false

    int N = 5;
    int[][] a = {
        {1, 2},
        {2, 3},
        {3, 4},
        {4, 5},
        {1, 5}
    };
    // Output: false
    System.out.println(possibleBiPartition(N, a));
  }

  public static boolean possibleBiPartition(int N, int[][] dislikes) {
    if(N == 1) return true;

    List[] map = new List[N + 1];
    for(int i = 0; i <= N; i++) {
      map[i] = new ArrayList<>();
    }
    for(int[] dislike: dislikes) {
      map[dislike[0]].add(dislike[1]);
      map[dislike[1]].add(dislike[0]);
    }

    int[] colours = new int[N+1];

    for(int i = 1; i <= N; i++) {
      colours[i] = -1;
    }

    for(int i = 1; i <= N; i++) {
      if(colours[i] == -1) {
        if(!isBiPartite(i, N, map, colours)) {
          return false;
        }
      }
    }
    return true;
  }

  // There are 2 colours {0, 1}. if the colour of a given vertex is 1,
  // then 1 -0 will diff colour to its neighbour
  static boolean isBiPartite(int s, int N, List[] map, int[] colours) {
    colours[s] = 1;
    q.add(s);
    while(!q.isEmpty()) {
      s = q.poll();
      List<Integer> neighbours = (List<Integer>)map[s];
      for(Integer u : neighbours) {
        if(colours[u]  == colours[s]) {
          return false;
        }
        if(colours[u] == -1) {
          colours[u] = 1 - colours[s]; // give diff colour to neighbour
          q.add(u);
        }

      }
    }
    return true;
  }
}

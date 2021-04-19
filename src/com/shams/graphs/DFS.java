/**
 * https://www.youtube.com/watch?v=CvUMf8c2JFo&list=PLEJXowNB4kPzByLnnFYNSCoqtFz0VKLk5&index=3&ab_channel=TECHDOSE
 **/

package com.shams.graphs;

import static com.shams.commons.UtilityHelper.getNeighbours;
import com.shams.commons.UtilityHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {

  static boolean[] visited;
  static Stack<Integer> stack = new Stack<>();

  public static void main(String[] args) {
    int[][] m = {
        {0, 1, 1, 0, 0, 0},
        {1, 0, 0, 1, 1, 0},
        {1, 0, 0, 0, 1, 0},
        {0, 1, 0, 0, 1, 1},
        {0, 1, 1, 1, 0, 1},
        {0, 0, 0, 1, 1, 0}
    };
    visited = new boolean[m.length];
    dfs(0, m);
  }

  private static void dfs(int s, int[][] m) {
    // stack is used just for understanding. Technically its not required
    stack.push(s);
    System.out.print(s + " ");
    visited[s] = true;
    List<Integer> neighbours = getNeighbours(s, m);
    for (Integer u : neighbours) {
      if (!visited[u]) {
        stack.push(u);
        dfs(u, m);
      }
    }
    stack.pop();
  }
}

/**
 * https://leetcode.com/problems/course-schedule-ii/
 * https://www.youtube.com/watch?v=qe_pQCh09yU&list=PLEJXowNB4kPzByLnnFYNSCoqtFz0VKLk5&index=13&ab_channel=TECHDOSE
 */

package com.shams.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CourseSchedule2 {
  public static void main(String[] args) {
    int[][] prerequisites = {
        {0, 2},
        {0, 1},
        {2, 3},
        {1, 3}
    };
    int numCourses = 4;
    System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
  }

  static LinkedList<Integer> result = new LinkedList<>();
  static Map<Integer, List<Integer>> map = new HashMap<>();

  public static int[] findOrder(int numCourses, int[][] prerequisites) {

    if (prerequisites == null) return new int[0];

    buildGraph(prerequisites);
    int[] colours = new int[numCourses];
    if (isCycle(numCourses, colours)) {
      return new int[0];
    }
    createCourseOrder(numCourses, prerequisites);

    //Collections.reverse(result);
    int[] a = new int[result.size()];
    for (int i = 0; i < result.size(); i++) {
      a[i] = result.get(i);
    }
    return a;
  }


  private static void createCourseOrder(int numCourses, int[][] prerequisites) {
    boolean[] visited = new boolean[numCourses];
    for (int i = 0; i < numCourses; i++) {
      if (!visited[i]) {
        dfs(i, visited);
      }
    }
  }

  private static void dfs(int s, boolean[] visited) {
    visited[s] = true;
    for (Integer n : map.getOrDefault(s, new ArrayList<>())) {
      if (!visited[n]) {
        dfs(n, visited);
      }
    }
    result.add(s);
  }

  private static void buildGraph(int[][] prerequisites) {
    for (int[] pr : prerequisites) {
      if (!map.containsKey(pr[0])) {
        map.put(pr[0], new ArrayList<>());
      }
      map.get(pr[0]).add(pr[1]);
    }
  }

  private static boolean isCycle(int numCourses, int[] colours) {
    for (int i = 0; i < numCourses; i++) {
      if (colours[i] == 0) {
        if (isCycleDFS(i, colours)) {
          return true;
        }
      }
    }
    return false;
  }

  private static boolean isCycleDFS(int s, int[] colours) {
    if (colours[s] == 2) return true;
    colours[s] = 2;
    for (Integer n : map.getOrDefault(s, new ArrayList<>())) {
      if (colours[n] != 1) {
        if (isCycleDFS(n, colours)) {
          return true;
        }
      }
    }
    colours[s] = 1;
    return false;
  }
}

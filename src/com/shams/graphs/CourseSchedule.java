/**
 * https://www.youtube.com/watch?v=kXy0ABd1vwo&list=PLEJXowNB4kPzByLnnFYNSCoqtFz0VKLk5&index=9&ab_channel=TECHDOSE
 * https://leetcode.com/problems/course-schedule/submissions/
 */

package com.shams.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {
  public static void main(String[] args) {
    int[][] a = {
        {2, 3},
        {1, 3},
        {0, 2},
        {1, 0}
    };

    // false example
    //  int[][] a = {
    //        {2, 3},
    //        {1, 3},
    //        {0, 2},
    //        {3, 1}
    //    };
    System.out.println(canFinish(4, a));
  }

  public static boolean canFinish(int numOfCourses, int[][] prerequisites) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    buildGraph(prerequisites, map);
    int[] visited = new int[numOfCourses+1];
    return isCycle(numOfCourses, map, visited);
  }


  //    3 -> 2 -> 0 -> 1


  // [
  //    2 -> [3]
  //    1 -> [3, 0]
  //    0 -> [2]
  // ]
  static void buildGraph(int[][] prerequisites, Map<Integer, List<Integer>> map) {
    for(int[] pr : prerequisites) {
      if(!map.containsKey(pr[0])) {
        map.put(pr[0], new ArrayList<>());
      }
      map.get(pr[0]).add(pr[1]);
    }
  }

  static boolean isCycle(int numOfCourses, Map<Integer, List<Integer>> map, int[] visited) {
    for(int i = 0; i <= numOfCourses; i++) {
      if(visited[i] == 0) {
        if(isCycleUtil(i, map, visited)) {
          return false;
        }
      }
    }
    return true;
  }

  private static boolean isCycleUtil(int s, Map<Integer, List<Integer>> map, int[] visited) {
    if(visited[s] == 2) return true;
    visited[s] = 2;
    for(Integer n : map.getOrDefault(s, new ArrayList<>())) {
      if(visited[n] != 1) {
        if(isCycleUtil(n, map, visited)) {
          return true;
        }
      }
    }
    visited[s] = 1;
    return false;
  }
}

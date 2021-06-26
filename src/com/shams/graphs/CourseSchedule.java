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
        {0, 2},
        {2, 3},
        {1, 3},
        {0, 1}
    };
    System.out.println(canFinish(4, a));
  }

  private static boolean canFinish(int numOfCourses, int[][] prerequisites) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for(int[] pr : prerequisites) {
      if(!map.containsKey(pr[0])) {
        map.put(pr[0], new ArrayList<>());
      }
      map.get(pr[0]).add(pr[1]);
    }
    System.out.println(map);
    int[] colours = new int[numOfCourses+1];
    for(int i = 0; i <= numOfCourses; i++) {
      if(colours[i] == 0) {
        if(isCycle(i, map, colours)) {
          return true;
        }
      }
    }
    return false;
  }

  private static boolean isCycle(int s, Map<Integer, List<Integer>> map, int[] colours) {
    if(colours[s] == 2) return true;
    colours[s] = 2;
    // 0 - not processed
    // 2 - In process
    // 1 - processed
    for(Integer n : map.getOrDefault(s, new ArrayList<>())) {
      if(colours[n] != 1) {
        if(isCycle(n, map, colours)) {
          return true;
        }
      }
    }
    colours[s] = 1;
    return false;
  }
}

/**
 * https://leetcode.com/problems/task-scheduler/submissions/
 * https://www.youtube.com/watch?v=lNaeiY4UKTw&ab_channel=WorkWithGoogler
 * */
package com.shams.greedy;

import java.util.HashMap;
import java.util.Map;

public class TaskScheduler {
  public static void main(String[] args) {
    // tasks = ["A","A","A","B","B","B"], n = 2
    char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
    int n = 2;
    System.out.println(leastInterval(tasks, n));
  }

  /**
   ex : 1
   AAABBBCCDE n = 2
   A--A--A
   AB-AB-AB
   ABCDABCEAB


   ABCDABCEAB
   Math.max(10, (3-1) * (3) + 2) = 10. Here tasks.length is the answer. i.e 10


   ex : 2
   AAABBB n = 2
   AB-AB-AB (including -) total is 8 time units
   */
  /**
   * 1. Find the tasks which takes max units of time. lets say there are m such tasks.
   * For ex : AAABBBCDE - There are 2 (m = 2) i.e A and B, tasks which takes 3 units of time
   * 2. These tasks in step 1 requires
   * Math.max(tasks.length, (numberOfTasksWithMaxTimeUnits -1) * (n + 1) + numberOfTasksWithMaxTimeUnits);
   */
  public static int leastInterval(char[] tasks, int n) {
    Map<Character, Integer> map = new HashMap<>();
    int maxTimeUnits = 0;
    for (char task : tasks) {
      map.put(task, map.getOrDefault(task, 0) + 1);
      maxTimeUnits = Math.max(maxTimeUnits, map.get(task));
    }

    int numOfTasksWithMaxTime = 0;
    for (Character c : map.keySet()) {
      if (map.get(c) == maxTimeUnits) {
        ++numOfTasksWithMaxTime;
      }
    }
    System.out.println(map + " numOfTasksWithMaxTime : " + numOfTasksWithMaxTime);
    return Math.max(tasks.length, ((maxTimeUnits - 1) * (n + 1)) + numOfTasksWithMaxTime);
  }
}

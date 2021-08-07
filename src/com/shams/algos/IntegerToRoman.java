/***
 * https://www.youtube.com/watch?v=yzB4M-UXqgI
 * https://leetcode.com/problems/integer-to-roman/submissions/
 * */

package com.shams.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class IntegerToRoman {

  public static void main(String[] args) {

    //System.out.println(intToRoman(1994));

    List<String> logs = List.of("712", "246", "365", "314");

    //{1=9789, 2=39311, 3=9742, 4=27578, 5=9523, 6=9620, 7=9700, 8=9544, 9=9683, 10=39634}
//    String st = "712";
//    int i = 7;
//    System.out.println(Character.forDigit(i, 10));
    System.out.println(slotWheels(logs));
  }
//      for (String s : history) {
//        int curMax = findMax(s);
//        int index = s.indexOf(Character.forDigit(curMax, 10));
//        s = s.substring(0, index) + s.substring(index + 1);
//        max = Math.max(max, curMax);
//      }
//      total += max;

  public static int slotWheels(List<String> history) {
    int total = 0;
    Queue<String> q = new LinkedList<>();
    for (String s : history) {
      q.add(s);
    }
    while (!q.isEmpty()) {
      int max = Integer.MIN_VALUE;
      int qSize = q.size();
      for (int i = 0; i < qSize; ++i) {
        String s = q.poll();
        int curMax = findMax(s);
        int index = s.indexOf(Character.forDigit(curMax, 10));
        s = s.substring(0, index) + s.substring(index + 1);
        if(!s.equals("")) {
          q.add(s);
        }
        max = Math.max(max, curMax);
      }
      total += max;
    }
    System.out.println(total);
    return total;
  }

  static int findMax(String s) {
    int curChar;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      curChar = c - '0';
      max = Math.max(max, curChar);
    }
    return max;
  }
}

//  public static List<String> processLogs(List<String> logs, int threshold) {
//    Map<String, Integer> transactionsCountMap = new HashMap<>();
//    List<String> result = new ArrayList<>();
//    transactionsCountMap.put("10", 39634);
//    transactionsCountMap.put("2", 39311);
//    transactionsCountMap.put("4", 27578);
////    for(String log : logs) {
////      String[] strArray = log.split("\\s+");
////      transactionsCountMap.put(strArray[0], transactionsCountMap.getOrDefault(strArray[0], 0) + 1);
////      if(!strArray[0].equals(strArray[1]))
////        transactionsCountMap.put(strArray[1], transactionsCountMap.getOrDefault(strArray[1], 0) + 1);
////    }
////      System.out.println(transactionsCountMap);
//    for(String key : transactionsCountMap.keySet()) {
//      if(transactionsCountMap.get(key) >= threshold) {
//        result.add(key);
//      }
//    }
//    // 1=9789, 2=39311, 3=9742, 4=27578, 5=9523, 6=9620, 7=9700, 8=9544, 9=9683, 10=39634
//
//    String[] strArray = (String[]) result.toArray();
//    Arrays.sort(strArray, new Comparator<String>()
//    {
//      public int compare(String s1, String s2)
//      {
//        return Integer.valueOf(s1).compareTo(Integer.valueOf(s2));
//      }
//    });
//    return Arrays.asList(strArray);
//  }





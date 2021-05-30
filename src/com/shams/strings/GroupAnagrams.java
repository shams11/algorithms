/**
 * https://leetcode.com/problems/group-anagrams/submissions/
 * */
package com.shams.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
  public static void main(String[] args) {
    //Input: strs = ["eat","tea","tan","ate","nat","bat"]
    //Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

    String[] strs = {"eat","tea","tan","ate","nat","bat"};
    System.out.println(groupAnagrams(strs));
  }

  public static List<List<String>> groupAnagrams(String[] strs) {
    if(strs == null || strs.length == 0) {
      return List.of();
    }
    List<List<String>> result = new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();
    for(String s : strs) {
      char[] charArray = s.toCharArray();
      Arrays.sort(charArray);
      String sortedString = new String(charArray);
      if(!map.containsKey(sortedString)) {
        map.put(sortedString, new ArrayList<>());
      }
      map.get(sortedString).add(s);
    }
    map.forEach((k, v) -> result.add(v));
    return result;
  }
}

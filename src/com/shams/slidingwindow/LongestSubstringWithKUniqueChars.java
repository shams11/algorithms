/**
 * https://www.youtube.com/watch?v=Lav6St0W_pQ&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=10&ab_channel=AdityaVerma
 * https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
 */

package com.shams.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniqueChars {

  public static void main(String[] args) {
    String s = "aabacbebebe";
    int k = 3;
    System.out.println(longestSubstringWithKUniqueCharacters(s, k));
  }

  private static int longestSubstringWithKUniqueCharacters(String s, int k) {
    if (s == null || s.length() == 0 || k <= 0) {
      return -1;
    }
    Map<Character, Integer> map = new HashMap<>();
    int i = 0, j = 0, max = Integer.MIN_VALUE;
    while (j < s.length()) {
      Character c = s.charAt(j);
      if (map.containsKey(c)) {
        map.put(c, map.getOrDefault(c, 0) + 1);
      } else {
        map.put(c, 1);
      }
      if (map.size() < k) {
        j++;
      } else if (map.size() == k) {
        max = Math.max(max, j - i + 1);
        j++;
      } else if (map.size() > k) {
        while (map.size() > k) {
          c = s.charAt(i);
          map.put(c, map.getOrDefault(c, 0) - 1);
          if (map.get(c) == 0) {
            map.remove(c);
          }
          i++;
        }
        j++;
      }
    }
    return max;
  }


//    static Map findUnique(char[] arr, int l, int r){
//      Map<Character,Integer> map = new HashMap<>();
//      int counter=0;
//      for(int i=l;i<r;i++){
//
//        if(map.containsKey(arr[i])){
//          counter= counter+1;
//          map.put(arr[i],map.get(arr[i])+1);
//        }else{
//          counter=1;
//          map.put(arr[i],counter);
//        }
//      }
//      return map;
//    }
//    public static int longestSubstringWithKUniqueCharacters(String s, int k) {
//      char[] arr = {'a', 'a', 'b', 'a', 'c', 'b', 'e', 'b', 'e', 'b', 'e'};
//      int l = 0;
//      int r = 0;
//      int max = 0;
//
//      while (r < arr.length) {
//
//        Map map = findUnique(arr,l,r);
//
//        if(map.size()<k){
//          r++;
//        }else if( map.size()==k){
//          if(r-l+1>max){
//            max = r-l+1;
//          }
//          r++;
//        }else if(map.size() > k){
//
//          while(map.size()>k){
//            map.put(arr[l], (int)map.get(arr[l])-1);
//            if((int)map.get(arr[l]) == 0){
//              map.remove(arr[l],map.get(arr[l]) );
//            }
//            l++;
//          }
//          r++;
//        }
//
//      }
//      return max;
//    }
}

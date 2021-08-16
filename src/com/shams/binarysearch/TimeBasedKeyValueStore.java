/***
 *  https://leetcode.com/problems/time-based-key-value-store/
 *  https://www.youtube.com/watch?v=kZAZqn_J8Fo&ab_channel=MichaelMuinos
 * */
package com.shams.binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore {
  public static void main(String[] args) {
    map = new HashMap<>();
    // Input
    //["TimeMap", "set", "get", "get", "set", "get", "get"]
    //[[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
    //Output
    //[null, null, "bar", "bar", null, "bar2", "bar2"]
    //
    //Explanation
    //TimeMap timeMap = new TimeMap();
    //timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
    //timeMap.get("foo", 1);         // return "bar"
    //timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
    //timeMap.set("foo", "bar2", 4); // store the key "foo" and value "ba2r" along with timestamp = 4.
    //timeMap.get("foo", 4);         // return "bar2"
    //timeMap.get("foo", 5);         // return "bar2"
    set("foo", "bar", 1);
    System.out.println(get("foo", 1));
    System.out.println(get("foo", 3));
    set("foo", "bar2", 4);
    set("foo", "bar2", 5);
    System.out.println(get("foo", 4));
    System.out.println(get("foo", 5));
  }

  static Map<String, List<Data>> map;

  public static class Data {
    String value;
    int time;
    Data(String val, int time) {
      this.value = val;
      this.time = time;
    }
  }

  public static void set(String key, String value, int timestamp) {
    if(!map.containsKey(key)) {
      map.put(key, new ArrayList<>());
    }
    map.get(key).add(new Data(value,timestamp));
  }

  public static String get(String key, int timestamp) {
    if(!map.containsKey(key)) {
      return "";
    }
    return findClosestValue(key, timestamp);
  }

  static String findClosestValue(String key, int timestamp) {
    List<Data> result = map.get(key);
    int end = result.size() - 1;
    int start = 0;
    while(start < end) {
      // target = 5
      // [(2, B), (5, C), (9, D), (15, E), (20, F)]
      // mid = 2, then 5 < 9, we move right to mid - 1
      // start = 0 and right = 1 now. mid will be
      // +1 here because, if right is 1 and left is 0, then mid is (0 + 1) / 2 = 0.
      // Now we set start to 0 again,and mid will be (0 + 1) / 2 = 0 again.
      // this will go in infinite loop
      int mid = (start + end + 1) / 2;
      if(result.get(mid).time <= timestamp) {
        start = mid;
      } else {
        end = mid - 1;
      }
    }
    Data data = result.get(start);
    // if there are no values less than given timestamp, then return ""
    // ex : if map has timestamp values  > 5, and the input timestamp is 4, then
    return data.time > timestamp ?  "" : data.value;
  }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */

// [foor => (bar, 1)]
// => get 1 => return bar
// => get 3 => return bar

// [foor => (bar2, 4)]
//  => get 4 => return bar2
//  => get 5 => return bar2


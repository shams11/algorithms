/**
 * https://leetcode.com/problems/remove-invalid-parentheses/
 * https://leetcode.com/problems/remove-invalid-parentheses/discuss/75032/Share-my-Java-BFS-solution
 */

package com.shams.paranthesis;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class MinRemoveInvalidParenReturnAllResults {
  public static void main(String[] args) {
    String s = "(a)())()";
    //System.out.println(isValid("("));
    System.out.println(removeInvalidParentheses(s));
  }

  public static List<String> removeInvalidParentheses(String s) {

    List<String> result = new ArrayList<>();
    Set<String> visited = new HashSet<>();
    Queue<String> q = new LinkedList<>();
    q.add(s);
    boolean found = false;

    while(!q.isEmpty()) {
      s = q.poll();
      if(isValid(s)) {
        result.add(s);
        found = true;
      }
      //  All items will be processed that are already enqueued.
      //However no new levels would be added because - if(found),
      // will not allow code execution to go ahead (instead - continue,
      // sends it back to while((!queue.isEmpty())).
      //And this is sufficient, because question asks us to find valid strings after minimum deletions.
      //Had the question been find all possible valid strings after any deletions
      // -- then we don't need if(found) condition.
      if(found) continue;

      for(int i = 0; i < s.length(); i++) {
        if(s.charAt(i) != '(' && s.charAt(i) != ')') continue;
        String t = s.substring(0, i) + s.substring(i + 1);

        if(!visited.contains(t)) {
          visited.add(t);
          q.add(t);
        }
      }
    }
    return result;
  }

  private static boolean isValid(String s) {
    int count = 0 ;
    for(int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if(c == '(') count++;
      if(c == ')' && count-- == 0) return false;
    }
    return count == 0;
  }
}

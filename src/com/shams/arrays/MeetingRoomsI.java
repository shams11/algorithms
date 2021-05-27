/**
 * https://leetcode.com/problems/meeting-rooms/
 */

package com.shams.arrays;

import java.util.Arrays;

public class MeetingRoomsI {
  public static void main(String[] args) {
//    int[][] a = {
//        {0, 30},
//        {5, 10},
//        {15, 20}
//    };
    // Output : false

    int[][] a = {
        {7, 10},
        {2,4}
    };
    // Output : true
    // Can a person attend all the meetings
    System.out.println(canAttendMeetings(a));
  }

  private static boolean canAttendMeetings(int[][] a) {
    int[] start = new int[a.length];
    int[] end = new int[a.length];
    for (int i = 0; i < a.length; i++) {
      start[i] = a[i][0];
    }
    for (int i = 0; i < a.length; i++) {
      end[i] = a[i][1];
    }
    Arrays.sort(start);
    Arrays.sort(end);
    for(int i = 1; i < start.length; i++) {
      if(start[i] < end[i-1]) {
        return false;
      }
    }
    return true;
  }
}

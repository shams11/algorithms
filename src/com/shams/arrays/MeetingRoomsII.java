/**
 * https://leetcode.com/problems/meeting-rooms-ii/
 * https://www.youtube.com/watch?v=FdzJmTCVyJU&ab_channel=NeetCodeNeetCode
 */

package com.shams.arrays;

import java.util.Arrays;

public class MeetingRoomsII {
  public static class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  public static void main(String[] args) {
    Interval[] intervals = {
        new Interval(0, 30),
        new Interval(5, 10),
        new Interval(15, 20)
    };

//    Interval[] intervals = {
//        new Interval(7, 10),
//        new Interval(2, 4)
//    };


//    Interval[] intervals = {
//        new Interval(900, 910),
//        new Interval(940, 1200),
//        new Interval(950, 1120),
//        new Interval(1100, 1130),
//        new Interval(1500, 1900),
//        new Interval(1800, 2000)
//    };

    System.out.println(minMeetingRooms(intervals));
  }

  private static int minMeetingRooms(Interval[] intervals) {
    int[] start = new int[intervals.length];
    int[] end = new int[intervals.length];
    for (int i = 0; i < start.length; i++) {
      start[i] = intervals[i].start;
    }
    for (int i = 0; i < end.length; i++) {
      end[i] = intervals[i].end;
    }
    Arrays.sort(start);
    Arrays.sort(end);
    int roomCount = 1;
    int result = Integer.MIN_VALUE;
    int i = 1, j = 0;
    while (i < start.length && j < end.length) {
      if (start[i] <= end[j]) {
        roomCount++;
        i++;
      } else {
        roomCount--;
        j++;
      }
      result = Math.max(result, roomCount);
    }
    return result;
  }
}

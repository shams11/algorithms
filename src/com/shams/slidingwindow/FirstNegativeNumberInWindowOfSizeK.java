/**
 * https://www.youtube.com/watch?v=uUXXEgK2Jh8&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=4&ab_channel=AdityaVerma
 * https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k/0#
 * */
package com.shams.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class FirstNegativeNumberInWindowOfSizeK {
  public static void main(String[] args) {
    int[] a = {12 -1 -7, 8, -15, 30, 16, 28};
    int k = 3;
    solve(a, k, a.length);
  }

  private static void solve(int[] a, int k, int n) {
    int i = 0, j = 0;
    List<Integer> list = new ArrayList<>();
    while(j < n) {
      if(a[j] < 0) {
        list.add(a[j]);
      }
      if(j -i + 1 < k) {
        j++;
      } else if (j -i + 1 == k){
        // j -i + 1 == k
        if(list.size() == 0) {
          System.out.println(0);
        } else {
          System.out.println(list.get(0));
          if(list.contains(a[i])) {
            list.remove(0);
          }
        }
        i++;
        j++;
      }
    }
  }
}

/***
 * https://www.interviewbit.com/problems/repeat-and-missing-number-array/#_=_
 * https://www.youtube.com/watch?v=G4_OxJGonQY&list=PL_z_8CaSLPWdJfdZHiNYYM46tYQUjbBJx&index=4&ab_channel=AdityaVerma
 * */

package com.shams.arrays;

import com.shams.commons.UtilityHelper;
import java.util.Arrays;

public class SwapSort {
  public static void main(String[] args) {
    //You are given a read only array of n integers from 1 to n
    //Each integer appears exactly once except A which appears twice and B which is missing.
    //Return A and B.

    //Input:[3 1 2 5 3]
    //Output:[3, 4]
    //A = 3, B = 4

    // Dry run
    /**
     *  3, 1, 2, 5, 3
     *  5, 1, 2, 3, 3
     *  3, 1, 2, 3, 5
     *  1, 3, 2, 3, 5
     *  1, 3, 2, 3, 5
     *  1, 2, 3, 3, 5
     * */
    int[] a = {3, 1, 2, 5, 3, 2, 7};
    findAllMissingAndDuplicateNumbers(a);
  }

  private static void findAllMissingAndDuplicateNumbers(int[] a) {
    int i = 0;
    while (i < a.length) {
      if (a[i] != a[a[i] - 1]) {
        UtilityHelper.swap(a, i, a[i] - 1);
      } else {
        i++;
      }
    }
    for (int j = 0; j < a.length; j++) {
      if (a[j] != j + 1) {
        System.out.println("Missing : " + (j + 1) + " Duplicate : " + a[j]);
      }
    }
  }
}

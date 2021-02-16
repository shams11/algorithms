/**
 * https://www.youtube.com/watch?v=ULUNeD0N9yI&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=19&ab_channel=AdityaVermap
 * */
package com.shams.recursion;

import java.util.ArrayList;
import java.util.List;

public class JosephusProblem {
  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(6);
    list.add(7);
    list.add(8);
    list.add(9);
    list.add(10);
    list.add(11);
    list.add(12);
    list.add(13);
    list.add(14);
    list.add(15);
    list.add(16);
    list.add(17);
    list.add(18);
    list.add(19);
    list.add(20);
    list.add(21);
    list.add(22);
    list.add(23);
    list.add(24);
    list.add(25);
    list.add(26);
    list.add(27);
    list.add(28);
    list.add(29);
    list.add(30);
    list.add(31);
    list.add(32);
    list.add(33);
    list.add(34);
    list.add(35);
    list.add(36);
    list.add(37);
    list.add(38);
    list.add(39);
    list.add(40);

    int k = 7;
    solve(list, k, 0);
  }

  private static void solve(List<Integer> list, int k, int currentIndex) {
    if(list.size() == 1) {
      System.out.println(list.get(0));
      return;
    }
    currentIndex = (currentIndex + k -1) % (list.size());
    list.remove(currentIndex);
    solve(list, k, currentIndex);
  }
}

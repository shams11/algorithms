/***
 * https://www.youtube.com/watch?v=e7Rx7ZEY1EE&ab_channel=WorkWithGoogler
 * https://leetcode.com/problems/design-tic-tac-toe/
 * */
package com.shams.games;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TicTacToe {
  public static void main(String[] args) {

    rowCount = new HashMap<>();
    colCount = new HashMap<>();
    diagCount = new HashMap<>();

    // Testing only for player 1.
    if (move(0, 0, 1) == 1) {
      System.out.println("Winner found!!");
      return;
    }
    if (move(0, 2, 1) == 1) {
      System.out.println("Winner found!!");
      return;
    }
    if (move(2, 2, 1) == 1) {
      System.out.println("Winner found!!");
      return;
    }
    if (move(1, 1, 2) == 1) {
      System.out.println("Winner found!!");
      return;
    }
    if (move(2, 0, 1) == 1) {
      System.out.println("Winner found!!");
      return;
    }
    if (move(1, 0, 2) == 1) {
      System.out.println("Winner found!!");
      return;
    }
    if (move(2, 1, 1) == 1) {
      System.out.println("Winner found!!");
    }
  }

  public static class Pair {
    int player;
    int rowOrCol;

    Pair(int player, int rowOrCol) {
      this.player = player;
      this.rowOrCol = rowOrCol;
    }

    @Override
    public boolean equals(Object o) {

      if (o == this) return true;
      if (!(o instanceof Pair)) {
        return false;
      }
      Pair pair = (Pair) o;
      return player == pair.player && rowOrCol == pair.rowOrCol;
    }

    @Override
    public int hashCode() {
      return Objects.hash(player, rowOrCol);
    }

  }

  static private Map<Pair, Integer> rowCount;
  static private Map<Pair, Integer> colCount;
  static private Map<Pair, Integer> diagCount;
  static int n = 3;

  public static int move(int row, int col, int player) {
    if (update(new Pair(player, row), rowCount)) {
      return player;
    }
    if (update(new Pair(player, row), colCount)) {
      return player;
    }
    if (row == col) {
      if (update(new Pair(player, -1), diagCount)) {
        return player;
      }
    }
    if (row + col == n - 1) {
      if (update(new Pair(player, 1), diagCount)) {
        return player;
      }
    }
    return 0;
  }

  private static boolean update(Pair pair, Map<Pair, Integer> map) {
    map.put(pair, map.getOrDefault(pair, 0) + 1);
    return map.get(pair) == n;
  }
}

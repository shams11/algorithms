package com.shams.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class MinKnightMoves {

  public static class Cell {
    int x;
    int y;
    int dist;

    public Cell(int x, int y, int dist) {
      this.x = x;
      this.y = y;
      this.dist = dist;
    }
  }

  static Queue<Cell> q = new LinkedList<>();

  public static void main(String[] args) {
    int N = 8;
    int[][] chessboard = new int[N][N];
    int[] src = {1, 1};
    int[] dst = {8, 8};
    System.out.println(calcMinKnightMoves(chessboard, src, dst, N));
  }

  static int[][] moves = {
      {2, 1},
      {1, 2},
      {-1, 2},
      {-2, 1},
      {2, -1},
      {1, -2},
      {-1, -2},
      {-2, -1}
  };

  private static int calcMinKnightMoves(int[][] chessboard, int[] src, int[] dst, int N) {
    q.add(new Cell(src[0] -1, src[1] - 1, 0));
    while (!q.isEmpty()) {
      Cell cur = q.poll();
      if (cur.x == dst[0] -1 && cur.y == dst[1] -1) {
        return cur.dist;
      }
      for (int[] m : moves) {
        int x = m[0] + cur.x;
        int y = m[1] + cur.y;
        if (x > -1 && x < N && y > -1 && y < N && chessboard[x][y] != -1) {
          chessboard[x][y] = -1;
          q.add(new Cell(x, y, cur.dist + 1));
        }
      }
    }
    return -1;
  }
}

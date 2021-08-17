package com.shams.graphs;

public class FloodFill {
  public static void main(String[] args) {
    // Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
    //Output: [[2,2,2],[2,2,0],[2,0,1]]
    //Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
    //Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
    int[][] image = {
        {1, 1, 1},
        {1, 1, 0},
        {1, 0, 1}
    };
    int sr = 1, sc = 1, newColor = 2;
    image = floodFill(image, sr, sc, newColor);
    printImage(image);
  }

  private static void printImage(int[][] image) {
    for (int i = 0; i < image.length; ++i) {
      for (int j = 0; j < image[0].length; ++j) {
        System.out.print(image[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    if (image[sr][sc] == newColor) return image;
    floodFillUtil(image, sr, sc, image[sr][sc], newColor);
    return image;
  }

  static void floodFillUtil(int[][] image, int sr, int sc, int color, int newColor) {
    if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != color)
      return;

    image[sr][sc] = newColor;
    floodFillUtil(image, sr + 1, sc, color, newColor);  // Up
    floodFillUtil(image, sr - 1, sc, color, newColor);  // down
    floodFillUtil(image, sr, sc + 1, color, newColor);  // right
    floodFillUtil(image, sr, sc - 1, color, newColor);  // left
  }
}

/**
 * https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
 * https://www.youtube.com/watch?v=zmPj_Ee3B8c&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=48
 */

package com.shams.trees.binarytrees;

import com.shams.commons.UtilityHelper;

public class Diameter {
  static int res = Integer.MIN_VALUE;

  public static void main(String[] args) {
    UtilityHelper.Node root = new UtilityHelper.Node(1);
    root.left = new UtilityHelper.Node(2);
    root.right = new UtilityHelper.Node(3);
    root.left.left = new UtilityHelper.Node(4);
    root.left.right = new UtilityHelper.Node(5);
    System.out.println(diameter(root));
  }

  public static int diameter(UtilityHelper.Node root) {
    if (root == null) {
      return 0;
    }
    calcDiameter(root);
    return res;
  }

  private static int calcDiameter(UtilityHelper.Node root) {
    if (root == null) {
      return 0;
    }
    int lsum = calcDiameter(root.left);
    int rsum = calcDiameter(root.right);

    int temp = 1 + Math.max(lsum, rsum);
    int ans = Math.max(temp, 1 + lsum + rsum);
    res = Math.max(ans, res);
    return temp;
  }
}

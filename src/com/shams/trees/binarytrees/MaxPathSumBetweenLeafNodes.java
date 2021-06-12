/***
 * https://www.youtube.com/watch?v=ArNyupe-XH0&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=50&ab_channel=AdityaVerma
 * https://www.geeksforgeeks.org/find-maximum-path-sum-two-leaves-binary-tree/
 * */

package com.shams.trees.binarytrees;

import com.shams.commons.UtilityHelper;

public class MaxPathSumBetweenLeafNodes {

  static int res = Integer.MIN_VALUE;

  public static void main(String[] args) {
    UtilityHelper.Node root = new UtilityHelper.Node(-15);
    root.left = new UtilityHelper.Node(5);
    root.right = new UtilityHelper.Node(6);
    root.left.left = new UtilityHelper.Node(-8);
    root.left.right = new UtilityHelper.Node(1);
    root.left.left.left = new UtilityHelper.Node(2);
    root.left.left.right = new UtilityHelper.Node(6);
    root.right.left = new UtilityHelper.Node(3);
    root.right.right = new UtilityHelper.Node(9);
    root.right.right.right = new UtilityHelper.Node(0);
    root.right.right.right.left = new UtilityHelper.Node(4);
    root.right.right.right.right = new UtilityHelper.Node(-1);
    root.right.right.right.right.left = new UtilityHelper.Node(10);
    System.out.println(maxPathSum(root));
  }

  /***
   * This is same as diameter of a binary tree
   * */
  public static int maxPathSum(UtilityHelper.Node root) {
    if (root == null) {
      return 0;
    }
    calcMaxPathSum(root);
    return res;
  }

  private static int calcMaxPathSum(UtilityHelper.Node root) {
    if (root == null) {
      return 0;
    }

    int lsum = calcMaxPathSum(root.left);
    int rsum = calcMaxPathSum(root.right);

    int temp = root.val + Math.max(lsum, rsum);
    int ans = Math.max(temp, root.val + lsum + rsum);
    res = Math.max(ans, res);
    return temp;
  }
}

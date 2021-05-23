/**
 * https://www.youtube.com/watch?v=Osz-Vwer6rw&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=49
 * https://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/submissions/
 */

package com.shams.trees.binarytrees;

import com.shams.commons.UtilityHelper;

public class MaxPathSum {
  static int res = Integer.MIN_VALUE;

  public static void main(String[] args) {
    UtilityHelper.Node root = new UtilityHelper.Node(10);
    root.left = new UtilityHelper.Node(2);
    root.right = new UtilityHelper.Node(10);
    root.left.left = new UtilityHelper.Node(20);
    root.left.right = new UtilityHelper.Node(1);
    root.right.right = new UtilityHelper.Node(-25);
    root.right.right.left = new UtilityHelper.Node(3);
    root.right.right.right = new UtilityHelper.Node(4);
    System.out.println(maxPathSum(root));
  }

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

    int temp = Math.max(root.val, root.val + Math.max(lsum, rsum));
    int ans = Math.max(temp, Math.max(root.val, root.val + lsum + rsum));
    res = Math.max(ans, res);
    return temp;
  }
}

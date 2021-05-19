/**
 * https://www.geeksforgeeks.org/check-if-given-preorder-inorder-and-postorder-traversals-are-of-same-tree/
 */

package com.shams.trees.binarytrees;

import com.shams.commons.UtilityHelper;
import java.util.HashMap;
import java.util.Map;

public class CheckInPrePoTraversalsBelongsToSameTree1 {

  public static void main(String[] args) {
    // Build binary tree using inorder and pre order traversals
    // Do post order traversal for the constructed tree and check
    // it is same as the given post order traversal
    int[] in = {4, 2, 5, 1, 3};
    int[] pre = {1, 2, 4, 5, 3};
    int[] po = {4, 5, 2, 3, 1};

    //Output : Yes
    //Explanation : All of the above three traversals are of
    //the same tree              1
    //                         /   \
    //                        2     3
    //                      /   \
    //                     4     5

    //Input : Inorder -> 4 2 5 1 3
    //        Preorder -> 1 5 4 2 3
    //        Post order -> 4 1 2 3 5
    //Output : No
    System.out.println(AreGivenTraversalsBelongToSameTree(in, pre, po));
  }

  static Map<Integer, Integer> map = new HashMap<>();
  private static boolean AreGivenTraversalsBelongToSameTree(int[] in, int[] pre, int[] po) {
    if (in.length != pre.length || in.length != po.length) return false;

    for(int i = 0; i < in.length; i++) {
      map.put(in[i], i);
    }
    UtilityHelper.Node root = buildTreeFromInAndPreOrder(in, pre, 0, in.length - 1);
    int result = evaluatePostorder(po, root, 0);
    if (result == -1) {
      return false;
    }
    return true;
  }

  private static int evaluatePostorder(int[] po, UtilityHelper.Node root, int index) {
    if (root == null) {
      return index;
    }
    index = evaluatePostorder(po, root.left, index);
    index = evaluatePostorder(po, root.right, index);
    if (po[index] == root.val) {
      index++;
    } else {
      return -1;
    }
    return index;
  }

  static int preIndex = 0;

  private static UtilityHelper.Node buildTreeFromInAndPreOrder(
      int[] in, int[] pre, int inStart, int inEnd) {

    if (inStart > inEnd) {
      return null;
    }
    UtilityHelper.Node root = new UtilityHelper.Node(pre[preIndex++]);
    // leaf node
    if (inStart == inEnd) {
      return root;
    }

    int rootIndex = map.get(root.val);

    root.left = buildTreeFromInAndPreOrder(in, pre, inStart, rootIndex - 1);
    root.right = buildTreeFromInAndPreOrder(in, pre, rootIndex + 1, inEnd);
    return root;
  }

  private static int search(int[] in, int inStart, int inEnd, int rootVal) {
    for (int i = inStart; i < inEnd; i++) {
      if (in[i] == rootVal) {
        return i;
      }
    }
    return -1;
  }
}

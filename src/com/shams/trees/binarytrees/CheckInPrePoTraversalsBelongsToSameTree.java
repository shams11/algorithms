/**
 * https://www.geeksforgeeks.org/check-if-given-preorder-inorder-and-postorder-traversals-are-of-same-tree-set-2/?ref=rp
 */

package com.shams.trees.binarytrees;

public class CheckInPrePoTraversalsBelongsToSameTree {


  public static void main(String[] args) {
//    int[] inorder = {4, 2, 5, 1, 3};
//    int[] preorder = {1, 2, 4, 5, 3};
//    int[] postorder = {4, 5, 2, 3, 1};

    int[] inorder = {4, 2, 5, 1, 3};
    int[] preorder = {1, 5, 4, 2, 3};
    int[] postorder = {4, 1, 2, 3, 5};

    int inLen = inorder.length;
    int preLen = preorder.length;
    int poLen = postorder.length;
    if (inLen != preLen || inLen != poLen) {
      System.out.println("not same tree");
      return;
    }
    System.out.println(checkTree(inorder, 0, preorder, 0, postorder, 0, inLen));
  }

  private static boolean checkTree(
      int[] in, int inLen,
      int[] pre, int preLen,
      int[] po, int poLen, int len) {

//    if(len == 0) {
//      return true;
//    }
    if(len == 1) {
      return (in[inLen] == pre[preLen] && in[inLen] == po[poLen]);
    }

    int index = -1;
    for(int i = inLen; i < inLen + len; i++) {
      if(in[i] == pre[preLen]) {
        index = i;
        break;
      }
    }
    if(index == -1) {
      return false;
    }

    boolean leftTree = checkTree(in, inLen,
        pre, preLen+1,
        po, poLen,
        index);
    boolean rightTree = checkTree(
        in, inLen+index+1,
        pre, 1 + preLen + index ,
        po, poLen + index,
        len - index -1);
    return (leftTree && rightTree);
  }
}

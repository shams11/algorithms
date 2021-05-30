/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */

package com.shams.lists;

public class CopyListWithRandomPointer {
  public static void main(String[] args) {
    Node node = new Node(7);
    copyRandomList(node);
  }

  static class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }

  public static Node copyRandomList(Node head) {
    if (head == null) {
      return null;
    }
    Node cur = head;
    Node nextNode = null;
    // create new Node and put this node in between the nodes of original list
    while (cur != null) {
      Node newNode = new Node(cur.val);
      nextNode = cur.next;
      cur.next = newNode;
      newNode.next = nextNode;
      cur = nextNode;
    }
    cur = head;
    // populate random pointer
    while (cur != null && cur.next != null) {
      if (cur.random != null) {
        cur.next.random = cur.random.next;
      }
      cur = cur.next.next;
    }
    cur = head;
    Node root = new Node(-1);
    Node copyCur = root;
    Node nextOriginalNode, copy;
    while (cur != null && cur.next != null) {
      nextOriginalNode = cur.next.next;

      // fix copy list pointers
      copy = cur.next;
      copyCur.next = copy;
      copyCur = copy;

      // fix original list pointers
      cur.next = nextOriginalNode;
      cur = nextOriginalNode;
    }
    return root.next;
  }
}

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

  // crate new nodes and populate in between original nodes
  public static Node copyRandomList(Node head) {
    if (head == null) return null;

    Node cur = head;
    Node newCopyNode;
    Node nextOriginalNode = null;
    // crate and populate new nodes of copy list in between nodes of original list
    while (cur != null) {
      newCopyNode = new Node(cur.val);
      nextOriginalNode = cur.next;

      cur.next = newCopyNode;
      newCopyNode.next = nextOriginalNode;
      cur = nextOriginalNode;
    }

    // link random pointers of copy list
    cur = head;
    while (cur != null && cur.next != null) {
      if (cur.random != null) {
        cur.next.random = cur.random.next;
      }
      cur = cur.next.next;
    }

    // segregate copy list and original list
    Node root = new Node(-1);
    Node copy, copyCur = root;
    cur = head;
    while (cur != null && cur.next != null) {
      nextOriginalNode = cur.next.next;

      // fix copy list
      copy = cur.next;
      copyCur.next = copy;
      copyCur = copy;

      // fix original list
      cur.next = nextOriginalNode;
      cur = nextOriginalNode;
    }
    return root.next;
  }
}

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * */
package com.shams.trie;

public class Trie {

  static class Node {
    char c;
    boolean isWord;
    Node[] children;
    Node(char c) {
      this.c = c;
      this.isWord = false;
      children = new Node[26];
    }
  }

  private final Node root;
  /** Initialize your data structure here. */
  public Trie() {
    root = new Node('/');
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    Node cur = root;
    for(int i =  0; i < word.length(); i++) {
      char c = word.charAt(i);
      if(cur.children[c - 'a'] == null) {
        cur.children[c - 'a'] = new Node(c);
      }
      cur = cur.children[c - 'a'];
    }
    cur.isWord = true;
  }

  /** Returns if the word is in the trie. */
  public boolean isWord(String word) {
    Node node = getNode(word);
    return node != null && node.isWord;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    Node node = getNode(prefix);
    return node != null;
  }

  private Node getNode(String word) {
    Node cur = root;
    for(int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if(cur.children[c - 'a'] == null) return null;
      cur = cur.children[c - 'a'];
    }
    return cur;
  }
}

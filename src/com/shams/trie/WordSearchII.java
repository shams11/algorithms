/**
 * https://leetcode.com/problems/word-search-ii/
 */

package com.shams.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {
  public static void main(String[] args) {

    //Output: ["eat","oath"]
//    char[][] board = {
//        {'o', 'a', 'a', 'n'},
//        {'e', 't', 'a', 'e'},
//        {'i', 'h', 'k', 'r'},
//        {'i', 'f', 'l', 'v'}
//    };
    // [["o","a","b","n"],["o","t","a","e"],["a","h","k","r"],["a","f","l","v"]]
    //["oa","oaa"]
    //String[] words = {"oath", "pea", "eat", "rain"};

//    char[][] board = {{'o','a','b','n'},{'o','t','a','e'},{'a','h','k','r'},{'a','f','l','v'}};
//    String[] words = {"oa","oaa"};

//    char[][] board = {{'a', 'a'}};
//    String[] words = {"aaa"};

    char[][] board = {{'a', 'b'}, {'c', 'd'}};
    String[] words = {"abcb"};
    System.out.println(findWords(board, words));
    // Time Complexity :
    // O(m * n * 4 ^ (maxlengthword))
    // because we can start as many as possible position = m*n of the grid
    // and then starting from any point we can go as long as maximum length word at any time.
    // We are using trie so that the words having common prefix or another way to say words
    // sharing common path in the grid can be search and store in result in a same traversal
    // of that path to save time.But in worst case it will take same time as bruteforce
    // approach without trie.
  }

  static Node root;

  public static class Node {
    char c;
    boolean isWord;
    Node[] children;

    Node(char c) {
      this.c = c;
      this.isWord = false;
      this.children = new Node[26];
    }
  }

  private static void insert(String word) {
    Node cur = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (cur.children[c - 'a'] == null) {
        cur.children[c - 'a'] = new Node(c);
      }
      cur = cur.children[c - 'a'];
    }
    cur.isWord = true;
  }

  private static Node getNode(String word) {
    Node cur = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (cur.children[c - 'a'] == null) return null;
      cur = cur.children[c - 'a'];
    }
    return cur;
  }

  static Set<String> result = new HashSet<>();

  public static List<String> findWords(char[][] board, String[] words) {
    root = new Node('/');
    for (String word : words) {
      insert(word);
    }
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        dfs(board, i, j, "");
      }
    }
    return new ArrayList<>(result);
  }

  static boolean startsWith(String word) {
    Node node = getNode(word);
    return node != null;
  }

  static boolean isWord(String word) {
    Node node = getNode(word);
    return node != null && node.isWord;
  }

  static void dfs(char[][] board, int i, int j, String str) {
    if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '$') {
      return;
    }
    char temp = board[i][j];
    str += temp;
    if (!startsWith(str)) {
      return;
    }
    if (isWord(str)) {
      result.add(str);
    }
    board[i][j] = '$';
    dfs(board, i + 1, j, str);
    dfs(board, i - 1, j, str);
    dfs(board, i, j - 1, str);
    dfs(board, i, j + 1, str);
    board[i][j] = temp;
  }
}


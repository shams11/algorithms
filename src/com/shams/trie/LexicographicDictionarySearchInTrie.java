/**
 * https://www.geeksforgeeks.org/sorting-array-strings-words-using-trie/
 */

package com.shams.trie;

public class LexicographicDictionarySearchInTrie {
  private static final int ALPHABET_COUNT = 26;

  public static class Trie {
    int index;
    Trie[] children = new Trie[ALPHABET_COUNT];

    Trie() {
      for (int i = 0; i < ALPHABET_COUNT; ++i) {
        children[i] = null;
        index = -1;
      }
    }
  }

  public static void insert(Trie root, String s, int stringIndexInArray) {
    Trie node = root;
    for (int i = 0; i < s.length(); ++i) {
      int charInString = s.charAt(i) - 'a';
      if (node.children[charInString] == null) {
        node.children[charInString] = new Trie();
      }
      node = node.children[charInString];
    }
    node.index = stringIndexInArray;
  }

  private static void search(Trie node, String[] arr) {
    if (node == null)
      return;

    for(int i = 0; i < ALPHABET_COUNT; ++i) {
      if(node.children[i] != null) {
        if(node.children[i].index != -1) {
          System.out.println(arr[node.children[i].index]);
        }
      }
      search(node.children[i], arr);
    }
  }

  public static void main(String[] args) {
    Trie root = new Trie();
    String[] arr = {"geeks", "for", "geeks", "a", "portal",
        "to", "learn", "can", "be", "computer",
        "science", "zoom", "yup", "fire", "in", "data"};
    for (int i = 0; i < arr.length; ++i) {
      insert(root, arr[i], i);
    }
    search(root, arr);
  }
}

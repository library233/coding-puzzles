package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._2._0._8;

/*

https://leetcode.com/problems/implement-trie-prefix-tree

208. Implement Trie (Prefix Tree)
(Medium)

A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

    Trie() Initializes the trie object.
    void insert(String word) Inserts the string word into the trie.
    boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
    boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.

Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True

Constraints:

    1 <= word.length, prefix.length <= 2000
    word and prefix consist only of lowercase English letters.
    At most 3 * 10^4 calls in total will be made to insert, search, and startsWith.

 */

import java.util.Optional;

class Trie {
    private final Node root = new Node();

    public Trie() {
    }

    public void insert(String word) {
        Node current = root;
        for (char c : word.toCharArray()) {
            int index = index(c);
            if (current.children[index] == null) {
                current.children[index] = new Node();
            }
            current = current.children[index];
        }
        current.terminal = true;
    }

    public boolean search(String word) {
        return Optional.of(word).map(this::walkThrough).filter(node -> node.terminal).isPresent();
    }

    public boolean startsWith(String prefix) {
        return Optional.of(prefix).map(this::walkThrough).isPresent();
    }

    private Node walkThrough(String s) {
        Node current = root;
        for (char c : s.toCharArray()) {
            int index = index(c);
            if (current.children[index] == null) {
                return null;
            }
            current = current.children[index];
        }
        return current;
    }

    private int index(char c) {
        return c - 'a';
    }

    private static class Node {
        private final Node[] children = new Node[26];
        private boolean terminal = false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._2._1._1;

/*

https://leetcode.com/problems/design-add-and-search-words-data-structure

211. Design Add and Search Words Data Structure
(Medium)

Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

    WordDictionary() Initializes the object.
    void addWord(word) Adds word to the data structure, it can be matched later.
    bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.

Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True

Constraints:

    1 <= word.length <= 25
    word in addWord consists of lowercase English letters.
    word in search consist of '.' or lowercase English letters.
    There will be at most 2 dots in word for search queries.
    At most 10^4 calls will be made to addWord and search.

 */

class WordDictionary {
    private final Trie trie = new Trie();

    public WordDictionary() {
    }

    public void addWord(String word) {
        trie.insert(word);
    }

    public boolean search(String word) {
        return trie.search(word);
    }

    private static class Trie {
        private final Node root = new Node();

        protected void insert(String word) {
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

        protected boolean search(String word) {
            return search(root, 0, word.toCharArray());
        }

        private boolean search(Node current, int next, char[] word) {
            if (next == word.length) {
                return current.terminal;
            }
            char c = word[next];
            if (c == '.') {
                for (Node child : current.children) {
                    if (child == null) {
                        continue;
                    }
                    if (search(child, next + 1, word)) {
                        return true;
                    }
                }
                return false;
            }
            int index = index(c);
            Node child = current.children[index];
            if (child == null) {
                return false;
            }
            return search(child, next + 1, word);
        }

        private int index(char c) {
            return c - 'a';
        }

        private static class Node {
            private final Node[] children = new Node[26];
            private boolean terminal = false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

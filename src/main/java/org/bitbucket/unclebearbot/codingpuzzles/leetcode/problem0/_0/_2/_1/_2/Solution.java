package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._2._1._2;

/*

https://leetcode.com/problems/word-search-ii

212. Word Search II
(Hard)

Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example 1:

    o  a  a  n          o  a  a  n          (o)(a) a  n
    e  t  a  e          e (t)(a)(e)          e (t) a  e
    i  h  k  r    ->    i  h  k  r    and    i (h) k  r
    i  f  l  v          i  f  l  v           i  f  l  v

Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]

Example 2:

    a  b
    c  d

Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []

Constraints:

    m == board.length
    n == board[i].length
    1 <= m, n <= 12
    board[i][j] is a lowercase English letter.
    1 <= words.length <= 3 * 10^4
    1 <= words[i].length <= 10
    words[i] consists of lowercase English letters.
    All the strings of words are unique.

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        return new Trie(words).search(board);
    }

    private static class Trie {
        private final Node root = new Node();

        protected Trie(String[] words) {
            Arrays.stream(words).forEach(this::insert);
        }

        private void insert(String word) {
            Node current = root;
            for (char c : word.toCharArray()) {
                int index = index(c);
                if (current.children[index] == null) {
                    current.children[index] = new Node();
                }
                current = current.children[index];
            }
            current.word = word;
        }

        protected List<String> search(char[][] board) {
            List<String> result = new ArrayList<>();
            for (int line = 0; line < board.length; ++line) {
                for (int column = 0; column < board[line].length; ++column) {
                    walkThrough(board, line, column, root, result);
                }
            }
            return result;
        }

        private void walkThrough(char[][] board, int line, int column, Node node, List<String> result) {
            if (line < 0 || line >= board.length || column < 0 || column >= board[0].length) {
                return;
            }
            char c = board[line][column];
            if (c == '\0') {
                return;
            }
            int index = index(c);
            if (node.children[index] == null) {
                return;
            }
            Node child = node.children[index];
            if (child.word != null && !child.visited) {
                result.add(child.word);
                child.visited = true;
            }
            board[line][column] = '\0';
            walkThrough(board, line - 1, column, child, result);
            walkThrough(board, line + 1, column, child, result);
            walkThrough(board, line, column - 1, child, result);
            walkThrough(board, line, column + 1, child, result);
            board[line][column] = c;
            if (Arrays.stream(child.children).allMatch(Objects::isNull)) {
                node.children[index] = null;
            }
        }

        private int index(char c) {
            return c - 'a';
        }

        private static class Node {
            private final Node[] children = new Node[26];
            private String word = null;
            private boolean visited = false;
        }
    }
}

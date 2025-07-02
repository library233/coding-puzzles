package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._6._4._8;

/*

https://leetcode.com/problems/replace-words

648. Replace Words
(Medium)

In English, we have a concept called root, which can be followed by some other word to form another longer word - let's call this word derivative. For example, when the root "help" is followed by the word "ful", we can form a derivative "helpful".

Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces, replace all the derivatives in the sentence with the root forming it. If a derivative can be replaced by more than one root, replace it with the root that has the shortest length.

Return the sentence after the replacement.

Example 1:

Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"

Example 2:

Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
Output: "a a b c"

Constraints:

    1 <= dictionary.length <= 1000
    1 <= dictionary[i].length <= 100
    dictionary[i] consists of only lower-case letters.
    1 <= sentence.length <= 10^6
    sentence consists of only lower-case letters and spaces.
    The number of words in sentence is in the range [1, 1000]
    The length of each word in sentence is in the range [1, 1000]
    Every two consecutive words in sentence will be separated by exactly one space.
    sentence does not have leading or trailing spaces.

 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        dictionary.forEach(trie::insert);
        return Arrays.stream(sentence.split(" ")).map(trie::findShortestRoot).collect(Collectors.joining(" "));
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

        protected String findShortestRoot(String word) {
            StringBuilder stringBuilder = new StringBuilder();
            Node current = root;
            for (char c : word.toCharArray()) {
                int index = index(c);
                if (current.children[index] == null) {
                    return word;
                }
                current = current.children[index];
                stringBuilder.append(c);
                if (current.terminal) {
                    return stringBuilder.toString();
                }
            }
            return word;
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

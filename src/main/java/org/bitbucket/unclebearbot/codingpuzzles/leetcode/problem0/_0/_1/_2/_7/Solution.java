package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._1._2._7;

/*

https://leetcode.com/problems/word-ladder

127. Word Ladder
(Hard)

A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

    Every adjacent pair of words differs by a single letter.
    Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
    sk == endWord

Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.

Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.

Constraints:

    1 <= beginWord.length <= 10
    endWord.length == beginWord.length
    1 <= wordList.length <= 5000
    wordList[i].length == beginWord.length
    beginWord, endWord, and wordList[i] consist of lowercase English letters.
    beginWord != endWord
    All the words in wordList are unique.

 */

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    private final List<Character> letters = IntStream.range(0, 26).mapToObj(i -> (char) ('a' + i)).collect(Collectors.toList());

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> available = new HashSet<>(wordList);
        if (!available.contains(endWord)) {
            return 0;
        }
        int count = 1;
        if (Objects.equals(beginWord, endWord)) {
            return count;
        }
        Set<String> transformed = new HashSet<>();
        transformed.add(beginWord);
        Queue<String> transforming = new LinkedList<>();
        transforming.offer(beginWord);
        while (!transforming.isEmpty()) {
            ++count;
            int size = transforming.size();
            for (int poll = 0; poll < size; ++poll) {
                char[] current = transforming.poll().toCharArray();
                for (int transform = 0; transform < current.length; ++transform) {
                    for (char letter : letters) {
                        char temp = current[transform];
                        if (temp == letter) {
                            continue;
                        }
                        current[transform] = letter;
                        String transformation = new String(current);
                        current[transform] = temp;
                        if (Objects.equals(transformation, endWord)) {
                            return count;
                        }
                        if (transformed.contains(transformation)) {
                            continue;
                        }
                        if (!available.contains(transformation)) {
                            continue;
                        }
                        transformed.add(transformation);
                        transforming.add(transformation);
                    }
                }
            }
        }
        return 0;
    }
}

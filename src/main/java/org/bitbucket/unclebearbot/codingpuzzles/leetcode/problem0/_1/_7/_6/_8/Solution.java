package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._1._7._6._8;

/*

https://leetcode.com/problems/merge-strings-alternately

1768. Merge Strings Alternately
(Easy)

You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.

Return the merged string.

Example 1:

Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r

Example 2:

Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
Explanation: Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b
word2:    p   q   r   s
merged: a p b q   r   s

Example 3:

Input: word1 = "abcd", word2 = "pq"
Output: "apbqcd"
Explanation: Notice that as word1 is longer, "cd" is appended to the end.
word1:  a   b   c   d
word2:    p   q
merged: a p b q c   d

Constraints:

    1 <= word1.length, word2.length <= 100
    word1 and word2 consist of lowercase English letters.

 */

class Solution {
    public String mergeAlternately(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < length1 && i < length2) {
            result.append(word1.charAt(i));
            result.append(word2.charAt(i));
            ++i;
        }
        if (i == length1) {
            result.append(word2, i, length2);
        } else {
            result.append(word1, i, length1);
        }
        return result.toString();
    }
}

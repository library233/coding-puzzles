package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._7._1._2;

/*

https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings

712. Minimum ASCII Delete Sum for Two Strings
(Medium)

Given two strings s1 and s2, return the lowest ASCII sum of deleted characters to make two strings equal.

Example 1:

Input: s1 = "sea", s2 = "eat"
Output: 231
Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
Deleting "t" from "eat" adds 116 to the sum.
At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.

Example 2:

Input: s1 = "delete", s2 = "leet"
Output: 403
Explanation: Deleting "dee" from "delete" to turn the string into "let",
adds 100[d] + 101[e] + 101[e] to the sum.
Deleting "e" from "leet" adds 101[e] to the sum.
At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.

Constraints:

    1 <= s1.length, s2.length <= 1000
    s1 and s2 consist of lowercase English letters.

 */

import java.util.stream.IntStream;

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        IntStream.rangeClosed(1, length1).forEach(substringLength1 -> dp[substringLength1][0] = dp[substringLength1 - 1][0] + s1.charAt(substringLength1 - 1));
        IntStream.rangeClosed(1, length2).forEach(substringLength2 -> dp[0][substringLength2] = dp[0][substringLength2 - 1] + s2.charAt(substringLength2 - 1));
        for (int prefixLength1 = 1; prefixLength1 <= length1; ++prefixLength1) {
            for (int prefixLength2 = 1; prefixLength2 <= length2; ++prefixLength2) {
                char char1 = s1.charAt(prefixLength1 - 1);
                char char2 = s2.charAt(prefixLength2 - 1);
                if (char1 == char2) {
                    dp[prefixLength1][prefixLength2] = dp[prefixLength1 - 1][prefixLength2 - 1];
                } else {
                    int delete1 = dp[prefixLength1 - 1][prefixLength2] + char1;
                    int delete2 = dp[prefixLength1][prefixLength2 - 1] + char2;
                    dp[prefixLength1][prefixLength2] = Math.min(delete1, delete2);
                }
            }
        }
        return dp[length1][length2];
    }
}

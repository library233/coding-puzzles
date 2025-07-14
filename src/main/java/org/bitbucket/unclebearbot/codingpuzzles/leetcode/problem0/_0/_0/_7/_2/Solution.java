package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._7._2;

/*

https://leetcode.com/problems/edit-distance

72. Edit Distance
(Medium)

Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

    Insert a character
    Delete a character
    Replace a character

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')

Constraints:

    0 <= word1.length, word2.length <= 500
    word1 and word2 consist of lowercase English letters.

 */

class Solution {
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int[][] minDistances = new int[length1 + 1][length2 + 1];
        for (int prefixLength1 = 0; prefixLength1 <= length1; ++prefixLength1) {
            minDistances[prefixLength1][0] = prefixLength1;
        }
        for (int prefixLength2 = 0; prefixLength2 <= length2; ++prefixLength2) {
            minDistances[0][prefixLength2] = prefixLength2;
        }
        for (int prefixLength1 = 1; prefixLength1 <= length1; ++prefixLength1) {
            for (int prefixLength2 = 1; prefixLength2 <= length2; ++prefixLength2) {
                int distanceIfInsert = minDistances[prefixLength1 - 1][prefixLength2] + 1;
                int distanceIfDelete = minDistances[prefixLength1][prefixLength2 - 1] + 1;
                boolean notActuallyReplace = word1.charAt(prefixLength1 - 1) == word2.charAt(prefixLength2 - 1);
                int distanceIfReplace = minDistances[prefixLength1 - 1][prefixLength2 - 1] + (notActuallyReplace ? 0 : 1);
                minDistances[prefixLength1][prefixLength2] = Math.min(Math.min(distanceIfInsert, distanceIfDelete), distanceIfReplace);
            }
        }
        return minDistances[length1][length2];
    }
}

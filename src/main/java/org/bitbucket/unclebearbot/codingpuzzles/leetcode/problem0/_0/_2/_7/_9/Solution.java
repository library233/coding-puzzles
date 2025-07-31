package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._2._7._9;

/*

https://leetcode.com/problems/perfect-squares

279. Perfect Squares
(Medium)

Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.

Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.

Constraints:

    1 <= n <= 10^4

 */

import java.util.stream.IntStream;

class Solution {
    public int numSquares(int n) {
        int[] counts = IntStream.rangeClosed(0, n).toArray();
        for (int number = 0; number <= n; ++number) {
            for (int sub = 1; sub < number; ++sub) {
                int subSquare = sub * sub;
                if (subSquare > number) {
                    break;
                }
                int countNotUsingSubSquare = counts[number];
                int countUsingSubSquare = counts[number - subSquare] + 1;
                counts[number] = Math.min(countNotUsingSubSquare, countUsingSubSquare);
            }
        }
        return counts[n];
    }
}

package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._4._4._1;

/*

https://leetcode.com/problems/arranging-coins

441. Arranging Coins
(Easy)

You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.

Given the integer n, return the number of complete rows of the staircase you will build.

Example 1:

    O
    O O
    O O _

Input: n = 5
Output: 2
Explanation: Because the 3rd row is incomplete, we return 2.

Example 2:

    O
    O O
    O O O
    O O _ _

Input: n = 8
Output: 3
Explanation: Because the 4th row is incomplete, we return 3.

Constraints:

    1 <= n <= 2^31 - 1

 */

class Solution {
    public int arrangeCoins(int n) {
        long left = 0;
        long right = n;
        while (left <= right) {
            long mid = (left + right) / 2;
            long coins = mid * (mid + 1) / 2;
            if (coins < n) {
                left = mid + 1;
                continue;
            }
            if (coins > n) {
                right = mid - 1;
                continue;
            }
            return (int) mid;
        }
        return (int) right;
    }
}

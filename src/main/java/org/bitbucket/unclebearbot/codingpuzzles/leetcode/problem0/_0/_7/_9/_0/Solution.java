package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._7._9._0;

/*

https://leetcode.com/problems/domino-and-tromino-tiling

790. Domino and Tromino Tiling
(Medium)

You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You may rotate these shapes.

    [# #]     [#]        [# #]      [#]
              [#]        [#]      [# #]

    (Domino tile)        (Tromino tile)

Given an integer n, return the number of ways to tile an 2 x n board. Since the answer may be very large, return it modulo 10^9 + 7.

In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.

Example 1:

    [1[2 2]    [1[2]3]    [1 1]3]    [1 1]2]    [1[2 2]
    [1[3 3]    [1[2]3]    [2 2]3]    [1[2 2]    [1 1]2]

Input: n = 3
Output: 5
Explanation: The five different ways are shown above.

Example 2:

    [1]
    [1]

Input: n = 1
Output: 1

Constraints:

    1 <= n <= 1000

 */

class Solution {
    private static final int MAGIC_MOD = (int) (Math.pow(10, 9) + 7);

    public int numTilings(int n) {
        if (n < 3) {
            return n;
        }
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; ++i) {
            dp[i] = (2 * dp[i - 1] + dp[i - 3]) % MAGIC_MOD;
        }
        return (int) dp[n];
    }
}

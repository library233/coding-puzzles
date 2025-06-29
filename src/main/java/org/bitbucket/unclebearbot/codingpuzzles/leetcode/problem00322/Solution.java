package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem00322;

/*

https://leetcode.com/problems/coin-change

322. Coin Change
(Medium)

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:

Input: coins = [2], amount = 3
Output: -1

Example 3:

Input: coins = [1], amount = 0
Output: 0

Constraints:

    1 <= coins.length <= 12
    1 <= coins[i] <= 2^31 - 1
    0 <= amount <= 10^4

 */

import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int invalid = amount + 1;
        Arrays.fill(dp, invalid);
        dp[0] = 0;
        for (int remain = 1; remain <= amount; ++remain) {
            for (int coin : coins) {
                if (coin > remain) {
                    continue;
                }
                int countUsingCurrentCoin = dp[remain - coin] + 1;
                int countNotUsingCurrentCoin = dp[remain];
                dp[remain] = Math.min(countUsingCurrentCoin, countNotUsingCurrentCoin);
            }
        }
        return dp[amount] == invalid ? -1 : dp[amount];
    }
}

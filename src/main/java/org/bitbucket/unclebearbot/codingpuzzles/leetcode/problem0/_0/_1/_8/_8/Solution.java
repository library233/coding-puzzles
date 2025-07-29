package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._1._8._8;

/*

https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv

188. Best Time to Buy and Sell Stock IV
(Hard)

You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

Example 1:

Input: k = 2, prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.

Example 2:

Input: k = 2, prices = [3,2,6,5,0,3]
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.

Constraints:

    1 <= k <= 100
    1 <= prices.length <= 1000
    0 <= prices[i] <= 1000

 */

class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k >= prices.length / 2) {
            int profit = 0;
            for (int i = 1; i < prices.length; ++i) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }
        int[][] maxProfits = new int[k + 1][2];
        for (int maxTransactions = 0; maxTransactions <= k; ++maxTransactions) {
            maxProfits[maxTransactions][0] = 0;
            maxProfits[maxTransactions][1] = Integer.MIN_VALUE;
        }
        for (int price : prices) {
            for (int remainingTransactions = k; remainingTransactions >= 1; --remainingTransactions) {
                int profitHoldingCash = maxProfits[remainingTransactions][0];
                int profitSellingStock = maxProfits[remainingTransactions][1] + price;
                maxProfits[remainingTransactions][0] = Math.max(profitHoldingCash, profitSellingStock);
                int profitHoldingStock = maxProfits[remainingTransactions][1];
                int profitBuyingStock = maxProfits[remainingTransactions - 1][0] - price;
                maxProfits[remainingTransactions][1] = Math.max(profitHoldingStock, profitBuyingStock);
            }
        }
        return maxProfits[k][0];
    }
}

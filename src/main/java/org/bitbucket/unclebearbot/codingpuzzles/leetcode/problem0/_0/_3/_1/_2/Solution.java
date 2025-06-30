package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._3._1._2;

/*

https://leetcode.com/problems/burst-balloons

312. Burst Balloons
(Hard)

You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.

If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.

Return the maximum coins you can collect by bursting the balloons wisely.

Example 1:

Input: nums = [3,1,5,8]
Output: 167
Explanation:
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167

Example 2:

Input: nums = [1,5]
Output: 10

Constraints:

    n == nums.length
    1 <= n <= 300
    0 <= nums[i] <= 100

 */

class Solution {
    public int maxCoins(int[] nums) {
        int length = nums.length;
        int[] balloons = new int[length + 2];
        System.arraycopy(nums, 0, balloons, 1, length);
        balloons[0] = 1;
        balloons[balloons.length - 1] = 1;
        int[][] dp = new int[balloons.length][balloons.length];
        for (int distance = 2; distance < balloons.length; ++distance) {
            for (int left = 0, right = left + distance; right < balloons.length; ++left, right = left + distance) {
                for (int lastShot = left + 1; lastShot < right; ++lastShot) {
                    int coinsHere = balloons[left] * balloons[lastShot] * balloons[right];
                    int maxCoinsFromLeftToHere = dp[left][lastShot];
                    int maxCoinsFromHereToRight = dp[lastShot][right];
                    int totalCoinsIfLastShotHere = coinsHere + maxCoinsFromLeftToHere + maxCoinsFromHereToRight;
                    dp[left][right] = Math.max(dp[left][right], totalCoinsIfLastShotHere);
                }
            }
        }
        return dp[0][balloons.length - 1];
    }
}

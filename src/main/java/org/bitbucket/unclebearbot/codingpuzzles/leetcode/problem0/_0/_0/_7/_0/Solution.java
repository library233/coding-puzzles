package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._7._0;

/*

https://leetcode.com/problems/climbing-stairs

70. Climbing Stairs
(Easy)

You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

Constraints:

    1 <= n <= 45

 */

class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int previous = 1;
        int current = 2;
        for (int i = 3; i <= n; ++i) {
            int next = current + previous;
            previous = current;
            current = next;
        }
        return current;
    }
}

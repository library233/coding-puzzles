package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._3._7._1;

/*

https://leetcode.com/problems/sum-of-two-integers

371. Sum of Two Integers
(Medium)

Given two integers a and b, return the sum of the two integers without using the operators + and -.

Example 1:

Input: a = 1, b = 2
Output: 3

Example 2:

Input: a = 2, b = 3
Output: 5

Constraints:

    -1000 <= a, b <= 1000

 */

class Solution {
    public int getSum(int a, int b) {
        int carry = b;
        while (carry != 0) {
            int nextCarry = (a & carry) << 1;
            a ^= carry;
            carry = nextCarry;
        }
        return a;
    }
}

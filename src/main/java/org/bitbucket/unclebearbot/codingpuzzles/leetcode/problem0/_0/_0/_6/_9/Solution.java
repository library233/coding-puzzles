package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._6._9;

/*

https://leetcode.com/problems/sqrtx

69. Sqrt(x)
(Easy)

Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

    For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.

Example 1:

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.

Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.

Constraints:

    0 <= x <= 2^31 - 1

 */

class Solution {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        long min = 1;
        long max = x / 2;
        long result = min;
        while (min <= max) {
            long mid = (min + max) / 2;
            long sq = mid * mid;
            if (sq < x) {
                result = mid;
                min = mid + 1;
            } else if (sq > x) {
                max = mid - 1;
            } else {
                result = mid;
                break;
            }
        }
        return (int) result;
    }
}

package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._2._0._4;

/*

https://leetcode.com/problems/count-primes

204. Count Primes
(Medium)

Given an integer n, return the number of prime numbers that are strictly less than n.

Example 1:

Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

Example 2:

Input: n = 0
Output: 0

Example 3:

Input: n = 1
Output: 0

Constraints:

    0 <= n <= 5 * 10^6

 */

import java.util.Arrays;

class Solution {
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for (int i = 2; i * i < n; ++i) {
            if (prime[i]) {
                for (int multiple = i * i; multiple < n; multiple += i) {
                    prime[multiple] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; ++i) {
            if (prime[i]) {
                ++count;
            }
        }
        return count;
    }
}

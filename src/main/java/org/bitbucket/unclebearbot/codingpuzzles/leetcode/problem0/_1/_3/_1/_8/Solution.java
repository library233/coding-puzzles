package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._1._3._1._8;

/*

https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c

1318. Minimum Flips to Make a OR b Equal to c
(Medium)

Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make ( a OR b == c ). (bitwise OR operation).
Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.

Example 1:

    a = 2          0 0 1 0          0 0 0 1
                       ` `              ` `
    b = 6          0 1 1 0          0 1 0 0
             ->        `      ->        `
                                    - - - -
                                    0 1 0 1    c = 5

Input: a = 2, b = 6, c = 5
Output: 3
Explanation: After flips a = 1 , b = 4 , c = 5 such that (a OR b == c)

Example 2:

    a = 4          0 1 0 0          0 1 0 1
                         `                `
    b = 2          0 0 1 0          0 0 1 0
             ->               ->
                                    - - - -
                                    0 1 1 1    c = 7

Input: a = 4, b = 2, c = 7
Output: 1

Example 3:

    a = 1          0 0 0 1          0 0 0 1

    b = 2          0 0 1 0          0 0 1 0
             ->               ->
                                    - - - -
                                    0 0 1 1    c = 3

Input: a = 1, b = 2, c = 3
Output: 0

Constraints:

    1 <= a <= 10^9
    1 <= b <= 10^9
    1 <= c <= 10^9

 */

class Solution {
    public int minFlips(int a, int b, int c) {
        int count = 0;
        while (a > 0 || b > 0 || c > 0) {
            int lowestBitOfA = a & 1;
            int lowestBitOfB = b & 1;
            int lowestBitOfC = c & 1;
            if (lowestBitOfC == 0) {
                if (lowestBitOfA != 0) {
                    ++count;
                }
                if (lowestBitOfB != 0) {
                    ++count;
                }
            } else {
                if (lowestBitOfA == 0 && lowestBitOfB == 0) {
                    ++count;
                }
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return count;
    }
}

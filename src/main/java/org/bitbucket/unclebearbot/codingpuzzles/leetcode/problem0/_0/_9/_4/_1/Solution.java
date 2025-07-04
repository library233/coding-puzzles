package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._9._4._1;

/*

https://leetcode.com/problems/valid-mountain-array

941. Valid Mountain Array
(Easy)

Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

    arr.length >= 3
    There exists some i with 0 < i < arr.length - 1 such that:
        arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
        arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

                             |
                      |      |
               |      |      |
        |      |      |      |      |
        |      |      |      |      |      |
----------------------------------------------------
(0) -> (2) -> (3) -> (4) -> (5) -> (2) -> (1) -> (0)
                  (Mountain Array)

                             |
                             |
               |      #      |
        |      |      #      |      |
        |      |      #      |      |      |
----------------------------------------------------
(0) -> (2) -> (3) -> [3] -> (5) -> (2) -> (1) -> (0)
               (Not a Mountain Array)

Example 1:

Input: arr = [2,1]
Output: false

Example 2:

Input: arr = [3,5,5]
Output: false

Example 3:

Input: arr = [0,3,2,1]
Output: true

Constraints:

    1 <= arr.length <= 10^4
    0 <= arr[i] <= 10^4

 */

class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int i = 0;
        while (i < arr.length - 1) {
            if (arr[i] < arr[i + 1]) {
                ++i;
            } else {
                break;
            }
        }
        if (i == 0 || i == arr.length - 1) {
            return false;
        }
        while (i < arr.length - 1) {
            if (arr[i] > arr[i + 1]) {
                ++i;
            } else {
                break;
            }
        }
        return i == arr.length - 1;
    }
}

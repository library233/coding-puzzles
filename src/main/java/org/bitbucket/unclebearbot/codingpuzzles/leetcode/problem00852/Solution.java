package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem00852;

/*

https://leetcode.com/problems/peak-index-in-a-mountain-array

852. Peak Index in a Mountain Array
(Medium)

You are given an integer mountain array arr of length n where the values increase to a peak element and then decrease.

Return the index of the peak element.

Your task is to solve it in O(log(n)) time complexity.

Example 1:

Input: arr = [0,1,0]

Output: 1

Example 2:

Input: arr = [0,2,1,0]

Output: 1

Example 3:

Input: arr = [0,10,5,2]

Output: 1

Constraints:

    3 <= arr.length <= 10^5
    0 <= arr[i] <= 10^6
    arr is guaranteed to be a mountain array.

 */

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        while (leftIndex < rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            if (arr[midIndex] < arr[midIndex + 1]) {
                leftIndex = midIndex + 1;
            } else {
                rightIndex = midIndex;
            }
        }
        return leftIndex;
    }
}

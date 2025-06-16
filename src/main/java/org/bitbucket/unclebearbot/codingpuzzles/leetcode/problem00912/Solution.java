package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem00912;

/*

https://leetcode.com/problems/sort-an-array

912. Sort an Array
Given an array of integers nums, sort the array in ascending order and return it.

You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.

Example 1:

Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).

Example 2:

Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]
Explanation: Note that the values of nums are not necessairly unique.

Constraints:

    1 <= nums.length <= 5 * 10^4
    -5 * 10^4 <= nums[i] <= 5 * 10^4

 */

class Solution {
    class TwoWay {
        public int[] sortArray(int[] nums) {
            sort(nums, 0, nums.length - 1);
            return nums;
        }

        private void sort(int[] nums, int beginIndex, int endIndex) {
            if (beginIndex >= endIndex) {
                return;
            }
            int pivot = pivot(nums, beginIndex, endIndex);
            sort(nums, beginIndex, pivot - 1);
            sort(nums, pivot + 1, endIndex);
        }

        private int pivot(int[] nums, int beginIndex, int endIndex) {
            int pivotValue = nums[endIndex];
            int pivotIndex = beginIndex;
            for (int i = beginIndex; i < endIndex; ++i) {
                if (nums[i] < pivotValue) {
                    swap(nums, i, pivotIndex);
                    ++pivotIndex;
                }
            }
            swap(nums, endIndex, pivotIndex);
            return pivotIndex;
        }

        private void swap(int[] nums, int a, int b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }

    class ThreeWay {
        public int[] sortArray(int[] nums) {
            sort(nums, 0, nums.length - 1);
            return nums;
        }

        private void sort(int[] nums, int beginIndex, int endIndex) {
            if (beginIndex >= endIndex) {
                return;
            }
            int[] pivots = pivots(nums, beginIndex, endIndex);
            int lessPivot = pivots[0];
            int greaterPivot = pivots[1];
            sort(nums, beginIndex, lessPivot - 1);
            sort(nums, greaterPivot + 1, endIndex);
        }

        private int[] pivots(int[] nums, int beginIndex, int endIndex) {
            int pivotValue = nums[endIndex];
            int i = beginIndex;
            while (i <= endIndex) {
                if (nums[i] < pivotValue) {
                    swap(nums, i, beginIndex);
                    ++beginIndex;
                    ++i;
                } else if (nums[i] > pivotValue) {
                    swap(nums, i, endIndex);
                    --endIndex;
                } else {
                    ++i;
                }
            }
            return new int[]{beginIndex, endIndex};
        }

        private void swap(int[] nums, int a, int b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }
}

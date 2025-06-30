package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._2._3._9;

/*

https://leetcode.com/problems/sliding-window-maximum

239. Sliding Window Maximum
(Hard)

You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

Example 2:

Input: nums = [1], k = 1
Output: [1]

Constraints:

    1 <= nums.length <= 10^5
    -10^4 <= nums[i] <= 10^4
    1 <= k <= nums.length

 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.IntStream;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int[] result = new int[length - k + 1];
        Deque<Integer> indices = new ArrayDeque<>();
        IntStream.range(0, length).forEach(i -> updateResult(result, indices, i, nums, k));
        return result;
    }

    private void updateResult(int[] result, Deque<Integer> indices, int windowEndIndex, int[] nums, int k) {
        int windowBeginIndex = windowEndIndex - k + 1;
        removeRetiredFromBegin(indices, windowBeginIndex);
        removeSmallerFromEnd(indices, windowEndIndex, nums);
        addToEnd(indices, windowEndIndex);
        setResult(result, indices, windowBeginIndex, nums);
    }

    private void removeRetiredFromBegin(Deque<Integer> indices, int windowBeginIndex) {
        if (!indices.isEmpty()) {
            if (indices.peekFirst() < windowBeginIndex) {
                indices.pollFirst();
            }
        }
    }

    private void removeSmallerFromEnd(Deque<Integer> indices, int windowEndIndex, int[] nums) {
        while (!indices.isEmpty()) {
            if (nums[indices.peekLast()] < nums[windowEndIndex]) {
                indices.pollLast();
            } else {
                break;
            }
        }
    }

    private void addToEnd(Deque<Integer> indices, int windowEndIndex) {
        indices.offerLast(windowEndIndex);
    }

    private void setResult(int[] result, Deque<Integer> indices, int windowBeginIndex, int[] nums) {
        if (windowBeginIndex >= 0) {
            result[windowBeginIndex] = nums[indices.peekFirst()];
        }
    }
}

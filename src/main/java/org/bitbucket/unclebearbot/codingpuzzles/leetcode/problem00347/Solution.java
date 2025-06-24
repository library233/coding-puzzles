package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem00347;

/*

https://leetcode.com/problems/top-k-frequent-elements

347. Top K Frequent Elements
(Medium)

Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:

Input: nums = [1], k = 1
Output: [1]

Constraints:

    1 <= nums.length <= 10^5
    -10^4 <= nums[i] <= 10^4
    k is in the range [1, the number of unique elements in the array].
    It is guaranteed that the answer is unique.

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

 */

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            int count = counts.getOrDefault(num, 0);
            counts.put(num, count + 1);
        }
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(counts.entrySet());
        int size = entries.size();
        int endIndex = size - 1;
        int target = size - k;
        select(entries, 0, endIndex, target);
        int[] result = new int[k];
        for (int i = 0; i < k; ++i) {
            result[i] = entries.get(endIndex - i).getKey();
        }
        return result;
    }

    private void select(List<Map.Entry<Integer, Integer>> entries, int beginIndex, int endIndex, int target) {
        if (beginIndex >= endIndex) {
            return;
        }
        int pivot = pivot(entries, beginIndex, endIndex);
        if (pivot == target) {
            return;
        }
        if (pivot < target) {
            select(entries, pivot + 1, endIndex, target);
        } else {
            select(entries, beginIndex, pivot - 1, target);
        }
    }

    private int pivot(List<Map.Entry<Integer, Integer>> entries, int beginIndex, int endIndex) {
        int pivotValue = entries.get(endIndex).getValue();
        int pivotIndex = beginIndex;
        for (int i = beginIndex; i < endIndex; ++i) {
            if (entries.get(i).getValue() < pivotValue) {
                Collections.swap(entries, i, pivotIndex);
                ++pivotIndex;
            }
        }
        Collections.swap(entries, endIndex, pivotIndex);
        return pivotIndex;
    }
}

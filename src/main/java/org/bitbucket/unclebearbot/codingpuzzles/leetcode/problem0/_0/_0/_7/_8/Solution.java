package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._7._8;

/*

https://leetcode.com/problems/subsets

78. Subsets
(Medium)

Given an integer array nums of unique elements, return all possible subset (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:

Input: nums = [0]
Output: [[],[0]]

Constraints:

    1 <= nums.length <= 10
    -10 <= nums[i] <= 10
    All the numbers of nums are unique.

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.emptyList());
        Arrays.sort(nums);
        IntStream.range(1, nums.length).forEach(size -> addSubsets(result, new ArrayList<>(), 0, size, nums));
        result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        return result;
    }

    private void addSubsets(List<List<Integer>> result, List<Integer> current, int begin, int size, int[] nums) {
        if (current.size() == size) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = begin; i < nums.length; ++i) {
            int num = nums[i];
            current.add(num);
            addSubsets(result, current, i + 1, size, nums);
            current.remove(current.size() - 1);
        }
    }
}

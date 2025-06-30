package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._4._6;

/*

https://leetcode.com/problems/permutations

46. Permutations
(Medium)

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:

Input: nums = [1]
Output: [[1]]

Constraints:

    1 <= nums.length <= 6
    -10 <= nums[i] <= 10
    All the integers of nums are unique.

 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return walkThrough(nums, new boolean[nums.length], new ArrayList<>(), new ArrayList<>());
    }

    private List<List<Integer>> walkThrough(int[] nums, boolean[] footprints, List<Integer> currentPath, List<List<Integer>> allPaths) {
        if (currentPath.size() != nums.length) {
            IntStream.range(0, nums.length).filter(i -> !footprints[i]).forEach(i -> visit(nums, footprints, currentPath, allPaths, i));
        } else {
            allPaths.add(new ArrayList<>(currentPath));
        }
        return allPaths;
    }

    private void visit(int[] nums, boolean[] footprints, List<Integer> currentPath, List<List<Integer>> allPaths, int index) {
        currentPath.add(nums[index]);
        footprints[index] = true;
        walkThrough(nums, footprints, currentPath, allPaths);
        currentPath.remove(currentPath.size() - 1);
        footprints[index] = false;
    }
}

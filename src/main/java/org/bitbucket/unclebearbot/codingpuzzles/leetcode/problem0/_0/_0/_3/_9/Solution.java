package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._3._9;

/*

https://leetcode.com/problems/combination-sum

39. Combination Sum
(Medium)

Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:

Input: candidates = [2], target = 1
Output: []

Constraints:

    1 <= candidates.length <= 30
    2 <= candidates[i] <= 40
    All elements of candidates are distinct.
    1 <= target <= 40

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        addValidCombinations(result, new ArrayList<>(), 0, target, candidates);
        return result;
    }

    private void addValidCombinations(List<List<Integer>> result, List<Integer> current, int begin, int remain, int[] candidates) {
        if (remain < 0) {
            return;
        }
        if (remain == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = begin; i < candidates.length; ++i) {
            int candidate = candidates[i];
            if (candidate > remain) {
                break;
            }
            current.add(candidate);
            addValidCombinations(result, current, i, remain - candidate, candidates);
            current.remove(current.size() - 1);
        }
    }
}

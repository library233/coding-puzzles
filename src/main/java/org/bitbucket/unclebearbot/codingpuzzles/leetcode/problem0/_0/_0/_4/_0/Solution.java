package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._4._0;

/*

https://leetcode.com/problems/combination-sum-ii

40. Combination Sum II
(Medium)

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]

Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output:
[
[1,2,2],
[5]
]

Constraints:

    1 <= candidates.length <= 100
    1 <= candidates[i] <= 50
    1 <= target <= 30

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        addCombinations(result, new ArrayList<>(), 0, target, candidates);
        return result;
    }

    private void addCombinations(List<List<Integer>> result, List<Integer> current, int begin, int gap, int[] candidates) {
        if (gap == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (gap < 0) {
            return;
        }
        for (int i = begin; i < candidates.length; ++i) {
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            current.add(candidates[i]);
            addCombinations(result, current, i + 1, gap - candidates[i], candidates);
            current.remove(current.size() - 1);
        }
    }
}

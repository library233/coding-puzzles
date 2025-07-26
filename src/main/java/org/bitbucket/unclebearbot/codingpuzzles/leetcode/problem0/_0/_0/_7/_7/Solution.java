package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._7._7;

/*

https://leetcode.com/problems/combinations

77. Combinations
(Medium)

Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.

Example 1:

Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.

Example 2:

Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.

Constraints:

    1 <= n <= 20
    1 <= k <= n

 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        addValidCombinations(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private void addValidCombinations(List<List<Integer>> result, List<Integer> current, int begin, int end, int target) {
        int size = current.size();
        if (size == target) {
            result.add(new ArrayList<>(current));
            return;
        }
        int maxPossibleEnd = end - (target - size) + 1;
        for (int i = begin; i <= maxPossibleEnd; ++i) {
            current.add(i);
            addValidCombinations(result, current, i + 1, end, target);
            current.remove(size);
        }
    }
}

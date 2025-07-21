package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._5._6;

/*

https://leetcode.com/problems/merge-intervals

56. Merge Intervals
(Medium)

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

Constraints:

    1 <= intervals.length <= 10^4
    intervals[i].length == 2
    0 <= starti <= endi <= 10^4

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; ++i) {
            int[] current = intervals[i];
            int[] last = result.get(result.size() - 1);
            if (last[1] < current[0]) {
                result.add(current);
            } else if (last[1] < current[1]) {
                last[1] = current[1];
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}

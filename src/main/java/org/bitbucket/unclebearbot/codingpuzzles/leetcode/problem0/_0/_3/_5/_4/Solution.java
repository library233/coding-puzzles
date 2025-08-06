package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._3._5._4;

/*

https://leetcode.com/problems/russian-doll-envelopes

354. Russian Doll Envelopes
(Hard)

You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.

One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.

Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).

Note: You cannot rotate an envelope.

Example 1:

Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
Output: 3
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

Example 2:

Input: envelopes = [[1,1],[1,1],[1,1]]
Output: 1

Constraints:

    1 <= envelopes.length <= 10^5
    envelopes[i].length == 2
    1 <= wi, hi <= 10^5

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            int comparingWidth = Integer.compare(a[0], b[0]);
            if (comparingWidth != 0) {
                return comparingWidth;
            }
            return Integer.compare(b[1], a[1]);
        });
        int[] heights = Arrays.stream(envelopes).mapToInt(envelope -> envelope[1]).toArray();
        return sizeOfLongestIncreasingSubsequence(heights);
    }

    private int sizeOfLongestIncreasingSubsequence(int[] nums) {
        List<Integer> mins = new ArrayList<>();
        for (int num : nums) {
            int index = Collections.binarySearch(mins, num);
            if (index < 0) {
                index = (index + 1) * -1;
            }
            if (index == mins.size()) {
                mins.add(num);
            } else {
                mins.set(index, num);
            }
        }
        return mins.size();
    }
}

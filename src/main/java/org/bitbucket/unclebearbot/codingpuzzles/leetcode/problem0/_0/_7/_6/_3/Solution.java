package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._7._6._3;

/*

https://leetcode.com/problems/partition-labels

763. Partition Labels
(Medium)

You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part. For example, the string "ababcc" can be partitioned into ["abab", "cc"], but partitions such as ["aba", "bcc"] or ["ab", "ab", "cc"] are invalid.

Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

Return a list of integers representing the size of these parts.

Example 1:

Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.

Example 2:

Input: s = "eccbbbbdec"
Output: [10]

Constraints:

    1 <= s.length <= 500
    s consists of lowercase English letters.

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> partitionLabels(String s) {
        int length = s.length();
        Map<Character, Integer> charsToLastAppearances = new HashMap<>();
        for (int appearance = length - 1; appearance >= 0; --appearance) {
            if (charsToLastAppearances.size() == 26) {
                break;
            }
            charsToLastAppearances.putIfAbsent(s.charAt(appearance), appearance);
        }
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = 0;
        for (int i = 0; i < length; ++i) {
            int lastAppearance = charsToLastAppearances.get(s.charAt(i));
            right = Math.max(right, lastAppearance);
            if (i == right) {
                int next = right + 1;
                result.add(next - left);
                left = next;
            }
        }
        return result;
    }
}

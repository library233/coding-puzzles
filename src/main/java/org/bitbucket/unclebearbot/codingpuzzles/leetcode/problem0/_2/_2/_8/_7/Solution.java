package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._2._2._8._7;

/*

https://leetcode.com/problems/rearrange-characters-to-make-target-string

2287. Rearrange Characters to Make Target String
(Easy)

You are given two 0-indexed strings s and target. You can take some letters from s and rearrange them to form new strings.

Return the maximum number of copies of target that can be formed by taking letters from s and rearranging them.

Example 1:

Input: s = "ilovecodingonleetcode", target = "code"
Output: 2
Explanation:
For the first copy of "code", take the letters at indices 4, 5, 6, and 7.
For the second copy of "code", take the letters at indices 17, 18, 19, and 20.
The strings that are formed are "ecod" and "code" which can both be rearranged into "code".
We can make at most two copies of "code", so we return 2.

Example 2:

Input: s = "abcba", target = "abc"
Output: 1
Explanation:
We can make one copy of "abc" by taking the letters at indices 0, 1, and 2.
We can make at most one copy of "abc", so we return 1.
Note that while there is an extra 'a' and 'b' at indices 3 and 4, we cannot reuse the letter 'c' at index 2, so we cannot make a second copy of "abc".

Example 3:

Input: s = "abbaccaddaeea", target = "aaaaa"
Output: 1
Explanation:
We can make one copy of "aaaaa" by taking the letters at indices 0, 3, 6, 9, and 12.
We can make at most one copy of "aaaaa", so we return 1.

Constraints:

    1 <= s.length <= 100
    1 <= target.length <= 10
    s and target consist of lowercase English letters.

Note: This question is the same as 1189: Maximum Number of Balloons.

 */

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int rearrangeCharacters(String s, String target) {
        Map<Character, Integer> stock = buildCharFreq(s);
        Map<Character, Integer> requirement = buildCharFreq(target);
        return timesAtMost(stock, requirement);
    }

    private Map<Character, Integer> buildCharFreq(String string) {
        Map<Character, Integer> result = new HashMap<>();
        for (char c : string.toCharArray()) {
            result.put(c, result.getOrDefault(c, 0) + 1);
        }
        return result;
    }

    private int timesAtMost(Map<Character, Integer> stock, Map<Character, Integer> requirement) {
        if (requirement.keySet().stream().anyMatch(c -> !stock.containsKey(c))) {
            return 0;
        }
        return requirement.entrySet().stream().mapToInt(charFreq -> stock.getOrDefault(charFreq.getKey(), 0) / charFreq.getValue()).min().getAsInt();
    }
}

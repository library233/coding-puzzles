package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._1._4._5._6;

/*

https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length

1456. Maximum Number of Vowels in a Substring of Given Length
(Medium)

Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.

Example 2:

Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.

Example 3:

Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.

Constraints:

    1 <= s.length <= 10^5
    s consists of lowercase English letters.
    1 <= k <= s.length

 */

class Solution {
    public int maxVowels(String s, int k) {
        String vowels = "aeiou";
        int windowCount = 0;
        for (int i = 0; i < k; ++i) {
            if (vowels.indexOf(s.charAt(i)) >= 0) {
                ++windowCount;
            }
        }
        int maxCount = windowCount;
        for (int i = k; i < s.length(); ++i) {
            if (vowels.indexOf(s.charAt(i)) >= 0) {
                ++windowCount;
            }
            if (vowels.indexOf(s.charAt(i - k)) >= 0) {
                --windowCount;
            }
            if (windowCount > maxCount) {
                maxCount = windowCount;
            }
        }
        return maxCount;
    }
}

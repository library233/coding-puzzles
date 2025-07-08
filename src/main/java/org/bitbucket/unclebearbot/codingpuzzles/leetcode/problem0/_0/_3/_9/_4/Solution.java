package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._3._9._4;

/*

https://leetcode.com/problems/decode-string

394. Decode String
(Medium)

Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 10^5.

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"

Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"

Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"

Constraints:

    1 <= s.length <= 30
    s consists of lowercase English letters, digits, and square brackets '[]'.
    s is guaranteed to be a valid input.
    All the integers in s are in the range [1, 300].

 */

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

class Solution {
    public String decodeString(String s) {
        return decode(s, new AtomicInteger());
    }

    private String decode(String s, AtomicInteger indexHolder) {
        StringBuilder result = new StringBuilder();
        int times = 0;
        while (true) {
            int i = indexHolder.getAndIncrement();
            if (i == s.length()) {
                break;
            }
            char c = s.charAt(i);
            if (c == ']') {
                break;
            }
            if (c == '[') {
                String token = decode(s, indexHolder);
                IntStream.range(0, times).forEach(time -> result.append(token));
                times = 0;
                continue;
            }
            if (Character.isDigit(c)) {
                int digit = c - '0';
                times = 10 * times + digit;
                continue;
            }
            result.append(c);
        }
        return result.toString();
    }
}

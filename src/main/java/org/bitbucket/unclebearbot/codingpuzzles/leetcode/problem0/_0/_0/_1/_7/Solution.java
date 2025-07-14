package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._1._7;

/*

https://leetcode.com/problems/letter-combinations-of-a-phone-number

17. Letter Combinations of a Phone Number
(Medium)

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

        +-------+-------+-------+
        |   1   |   2   |   3   |
        |       |  abc  |  def  |
        +-------+-------+-------+
        |   4   |   5   |   6   |
        |  ghi  |  jkl  |  mno  |
        +-------+-------+-------+
        |   7   |   8   |   9   |
        |  pqrs |  tuv  |  wxyz |
        +-------+-------+-------+

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:

Input: digits = ""
Output: []

Example 3:

Input: digits = "2"
Output: ["a","b","c"]

Constraints:

    0 <= digits.length <= 4
    digits[i] is a digit in the range ['2', '9'].

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    String[][] keys = new String[][]{
            new String[]{},
            new String[]{},
            new String[]{"a", "b", "c"},
            new String[]{"d", "e", "f"},
            new String[]{"g", "h", "i"},
            new String[]{"j", "k", "l"},
            new String[]{"m", "n", "o"},
            new String[]{"p", "q", "r", "s"},
            new String[]{"t", "u", "v"},
            new String[]{"w", "x", "y", "z"}
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        result.add("");
        for (char digit : digits.toCharArray()) {
            int number = digit - '0';
            List<String> letters = Arrays.asList(keys[number]);
            result = cartesianProduct(result, letters);
        }
        return result;
    }

    private List<String> cartesianProduct(List<String> strings1, List<String> strings2) {
        return strings1.stream().flatMap(s1 -> strings2.stream().map(s2 -> s1 + s2)).collect(Collectors.toList());
    }
}

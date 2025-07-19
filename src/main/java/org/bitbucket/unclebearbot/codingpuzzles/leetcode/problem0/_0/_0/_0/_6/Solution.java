package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._0._6;

/*

https://leetcode.com/problems/zigzag-conversion

6. Zigzag Conversion
(Medium)

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);

Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I

Example 3:

Input: s = "A", numRows = 1
Output: "A"

Constraints:

    1 <= s.length <= 1000
    s consists of English letters (lower-case and upper-case), ',' and '.'.
    1 <= numRows <= 1000

 */

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        List<StringBuilder> lines = IntStream.range(0, numRows).mapToObj(i -> new StringBuilder()).collect(Collectors.toList());
        int direction = 1;
        int cursor = 0;
        for (char c : s.toCharArray()) {
            lines.get(cursor).append(c);
            cursor += direction;
            if (cursor == 0 || cursor == numRows - 1) {
                direction *= -1;
            }
        }
        StringBuilder result = new StringBuilder();
        lines.forEach(result::append);
        return result.toString();
    }
}

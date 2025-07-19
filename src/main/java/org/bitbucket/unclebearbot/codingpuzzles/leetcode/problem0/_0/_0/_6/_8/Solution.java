package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._6._8;

/*

https://leetcode.com/problems/text-justification

68. Text Justification
(Hard)

Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left-justified, and no extra space is inserted between words.

Note:

    A word is defined as a character sequence consisting of non-space characters only.
    Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
    The input array words contains at least one word.

Example 1:

Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]

Example 2:

Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
Note that the second line is also left-justified because it contains only one word.

Example 3:

Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]

Constraints:

    1 <= words.length <= 300
    1 <= words[i].length <= 20
    words[i] consists of only English letters and symbols.
    1 <= maxWidth <= 100
    words[i].length <= maxWidth

 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<>();
        lines.add(words[0]);
        for (int i = 1; i < words.length; ++i) {
            String word = words[i];
            String line = lines.get(lines.size() - 1);
            if (line.length() + 1 + word.length() <= maxWidth) {
                lines.set(lines.size() - 1, line + " " + word);
            } else {
                lines.add(word);
            }
        }
        for (int i = 0; i < lines.size() - 1; ++i) {
            String line = lines.get(i);
            if (!line.contains(" ")) {
                continue;
            }
            int spaceIndex = -1;
            while (line.length() < maxWidth) {
                spaceIndex = line.indexOf(" ", spaceIndex + 2);
                if (spaceIndex < 0) {
                    continue;
                }
                line = line.substring(0, spaceIndex) + '\0' + line.substring(spaceIndex);
            }
            lines.set(i, line.replace('\0', ' '));
        }
        for (int i = 0; i < lines.size(); ++i) {
            StringBuilder line = new StringBuilder(lines.get(i));
            while (line.length() < maxWidth) {
                line.append(" ");
            }
            lines.set(i, line.toString());
        }
        return lines;
    }
}

package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._9._7;

/*

https://leetcode.com/problems/interleaving-string

97. Interleaving String
(Medium)

Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

An interleaving of two strings s and t is a configuration where s and t are divided into n and m substrings respectively, such that:

    s = s1 + s2 + ... + sn
    t = t1 + t2 + ... + tm
    |n - m| <= 1
    The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...

Note: a + b is the concatenation of strings a and b.

Example 1:

    (aa)(bc)(c)  (dbbc)(a)
     1   2   3     4    5
     |     \   \ /     /
     |      \ /   \  /
     |     / \     / \
     1    4    2   5  3
    (aa)(dbbc)(bc)(a)(c)

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Explanation: One way to obtain s3 is:
Split s1 into s1 = "aa" + "bc" + "c", and s2 into s2 = "dbbc" + "a".
Interleaving the two splits, we get "aa" + "dbbc" + "bc" + "a" + "c" = "aadbbcbcac".
Since s3 can be obtained by interleaving s1 and s2, we return true.

Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
Explanation: Notice how it is impossible to interleave s2 with any other string to obtain s3.

Example 3:

Input: s1 = "", s2 = "", s3 = ""
Output: true

Constraints:

    0 <= s1.length, s2.length <= 100
    0 <= s3.length <= 200
    s1, s2, and s3 consist of lowercase English letters.

Follow up: Could you solve it using only O(s2.length) additional memory space?

 */

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        populateByNotUsingAny(dp);
        populateByOnlyUsing1(s1, s3, dp);
        populateByOnlyUsing2(s2, s3, dp);
        populateByUsingBoth(s1, s2, s3, dp);
        return dp[s1.length()][s2.length()];
    }

    private void populateByNotUsingAny(boolean[][] dp) {
        dp[0][0] = true;
    }

    private void populateByOnlyUsing1(String s1, String s3, boolean[][] dp) {
        for (int prefixLength1 = 1; prefixLength1 <= s1.length(); ++prefixLength1) {
            boolean canUsePrefix = dp[prefixLength1 - 1][0];
            if (!canUsePrefix) {
                return;
            }
            int index1 = prefixLength1 - 1;
            dp[prefixLength1][0] = isEqualCharAt(s1, s3, index1);
        }
    }

    private void populateByOnlyUsing2(String s2, String s3, boolean[][] dp) {
        for (int prefixLength2 = 1; prefixLength2 <= s2.length(); ++prefixLength2) {
            boolean canUsePrefix = dp[0][prefixLength2 - 1];
            if (!canUsePrefix) {
                return;
            }
            int index2 = prefixLength2 - 1;
            dp[0][prefixLength2] = isEqualCharAt(s2, s3, index2);
        }
    }

    private void populateByUsingBoth(String s1, String s2, String s3, boolean[][] dp) {
        for (int prefixLength1 = 1; prefixLength1 <= s1.length(); ++prefixLength1) {
            for (int prefixLength2 = 1; prefixLength2 <= s2.length(); ++prefixLength2) {
                boolean canUsePrefixFrom1 = dp[prefixLength1 - 1][prefixLength2];
                int index1 = prefixLength1 - 1;
                boolean canUseCurrentCharFrom1 = canUsePrefixFrom1 && isEqualCharAt(s1, s3, index1, prefixLength2);
                boolean canUsePrefixFrom2 = dp[prefixLength1][prefixLength2 - 1];
                int index2 = prefixLength2 - 1;
                boolean canUseCurrentCharFrom2 = canUsePrefixFrom2 && isEqualCharAt(s2, s3, index2, prefixLength1);
                boolean canFormBySubstringsOfTheseLengths = canUseCurrentCharFrom1 || canUseCurrentCharFrom2;
                dp[prefixLength1][prefixLength2] = canFormBySubstringsOfTheseLengths;
            }
        }
    }

    private boolean isEqualCharAt(String source, String target, int index) {
        return source.charAt(index) == target.charAt(index);
    }

    private boolean isEqualCharAt(String source, String target, int index, int targetOffset) {
        return source.charAt(index) == target.charAt(index + targetOffset);
    }
}

package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._2._7._8;

/*

https://leetcode.com/problems/first-bad-version

278. First Bad Version
(Easy)

You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

Example 1:

Input: n = 5, bad = 4
Output: 4
Explanation:
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.

Example 2:

Input: n = 1, bad = 1
Output: 1

Constraints:

    1 <= bad <= n <= 2^31 - 1

 */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long min = 1;
        long max = n;
        while (min < max) {
            long mid = (min + max) / 2;
            if (isBadVersion((int) mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return (int) min;
    }
}

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

class VersionControl {
    boolean isBadVersion(int version) {
        return isProblemCreatedBy(version) || isBadVersion(version - 1);
    }

    private boolean isProblemCreatedBy(int version) {
        // check for problem
        return false;
    }
}

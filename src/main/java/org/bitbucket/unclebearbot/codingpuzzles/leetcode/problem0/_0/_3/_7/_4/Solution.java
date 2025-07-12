package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._3._7._4;

/*

https://leetcode.com/problems/guess-number-higher-or-lower

374. Guess Number Higher or Lower
(Easy)

We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.

You call a pre-defined API int guess(int num), which returns three possible results:

    -1: Your guess is higher than the number I picked (i.e. num > pick).
    1: Your guess is lower than the number I picked (i.e. num < pick).
    0: your guess is equal to the number I picked (i.e. num == pick).

Return the number that I picked.

Example 1:

Input: n = 10, pick = 6
Output: 6

Example 2:

Input: n = 1, pick = 1
Output: 1

Example 3:

Input: n = 2, pick = 1
Output: 1

Constraints:

    1 <= n <= 2^31 - 1
    1 <= pick <= n

 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        long left = 1;
        long right = n;
        while (left <= right) {
            int mid = (int) ((left + right) / 2);
            switch (guess(mid)) {
                case -1:
                    right = mid - 1;
                    break;
                case 1:
                    left = mid + 1;
                    break;
                case 0:
                    return mid;
                default:
                    throw new IllegalStateException();
            }
        }
        throw new IllegalStateException();
    }
}

class GuessGame {
    private int picked;

    /**
     * Forward declaration of guess API.
     * @param  num   your guess
     * @return 	     -1 if num is higher than the picked number
     *			      1 if num is lower than the picked number
     *               otherwise return 0
     * int guess(int num);
     */
    int guess(int num) {
        return Integer.compare(picked, num);
    }
}

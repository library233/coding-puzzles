package org.bitbucket.unclebearbot.codingpuzzles.codility.lesson017.task01;

import org.bitbucket.unclebearbot.utils.Assertions;

/*

https://app.codility.com/programmers/lessons/17-dynamic_programming/number_solitaire

# NumberSolitaire
# In a given array, find the subset of maximal sum in which the distance between consecutive elements is at most 6.

A game for one player is played on a board consisting of N consecutive squares, numbered from 0 to N − 1.
There is a number written on each square.
A non-empty array A of N integers contains the numbers written on the squares.
Moreover, some squares can be marked during the game.

At the beginning of the game, there is a pebble on square number 0 and this is the only square on the board which is marked.
The goal of the game is to move the pebble to square number N − 1.

During each turn we throw a six-sided die, with numbers from 1 to 6 on its faces, and consider the number K, which shows on the upper face after the die comes to rest.
Then we move the pebble standing on square number I to square number I + K, providing that square number I + K exists.
If square number I + K does not exist, we throw the die again until we obtain a valid move.
Finally, we mark square number I + K.

After the game finishes (when the pebble is standing on square number N − 1), we calculate the result.
The result of the game is the sum of the numbers written on all marked squares.

For example, given the following array:
    A[0] = 1
    A[1] = -2
    A[2] = 0
    A[3] = 9
    A[4] = -1
    A[5] = -2
one possible game could be as follows:
    the pebble is on square number 0, which is marked;
    we throw 3; the pebble moves from square number 0 to square number 3; we mark square number 3;
    we throw 5; the pebble does not move, since there is no square number 8 on the board;
    we throw 2; the pebble moves to square number 5; we mark this square and the game ends.

The marked squares are 0, 3 and 5, so the result of the game is 1 + 9 + (−2) = 8.
This is the maximal possible result that can be achieved on this board.

Write a function:
    class Solution { public int solution(int[] A); }
that, given a non-empty array A of N integers, returns the maximal result that can be achieved on the board represented by array A.

For example, given the array
    A[0] = 1
    A[1] = -2
    A[2] = 0
    A[3] = 9
    A[4] = -1
    A[5] = -2
the function should return 8, as explained above.

Write an efficient algorithm for the following assumptions:
    N is an integer within the range [2..100,000];
    each element of array A is an integer within the range [−10,000..10,000].

 */

public class Solution {
    public static void main(String[] args) {
        test(new Solution());
        System.out.println(Solution.class);
    }

    public int solution(int[] A) {
        int n = A.length;
        if (n <= 1) {
            return A[0];
        }
        int[] dp = new int[n];
        dp[0] = A[0];
        for (int i = 1; i < n; ++i) {
            int max_val = Integer.MIN_VALUE;
            for (int j = 1; j <= 6; ++j) {
                if (i - j >= 0) {
                    if (dp[i - j] != Integer.MIN_VALUE) {
                        max_val = Math.max(max_val, dp[i - j]);
                    }
                }
            }
            if (max_val != Integer.MIN_VALUE) {
                dp[i] = max_val + A[i];
            } else {
                dp[i] = Integer.MIN_VALUE;
            }
        }
        return dp[n - 1] == Integer.MIN_VALUE ? -1 : dp[n - 1];
    }

    public static void test(Solution solution) {
        Assertions.equalObjects(solution.solution(new int[]{1, -2, 0, 9, -1, -2}), 8);
        Assertions.equalObjects(solution.solution(new int[]{1, 2}), 3);
        Assertions.equalObjects(solution.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}), 55);
        Assertions.equalObjects(solution.solution(new int[]{1, -5, -5, -5, -5, -5, 10}), 11);
        Assertions.equalObjects(solution.solution(new int[]{1, 0}), 1);
        Assertions.equalObjects(solution.solution(new int[]{1, -100}), -99);
        Assertions.equalObjects(solution.solution(new int[]{-5, 5}), 0);
    }
}

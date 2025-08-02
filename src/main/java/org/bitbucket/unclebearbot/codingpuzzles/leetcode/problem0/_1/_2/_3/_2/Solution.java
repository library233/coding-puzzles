package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._1._2._3._2;

/*

https://leetcode.com/problems/check-if-it-is-a-straight-line

1232. Check If It Is a Straight Line
(Easy)

You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.

Example 1:

      ^
    8 +
      |
    7 +                                               *
      |
    6 +                                       *
      |
    5 +                               *
      |
    4 +                       *
      |
    3 +               *
      |
    2 +       *
      |
    1 +
      |
    --+-------+-------+-------+-------+-------+-------+-------+-------+-->
    O |       1       2       3       4       5       6       7       8

Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true

Example 2:

      ^
    8 +
      |
    7 +                                                       *
      |
    6 +                                       *
      |
    5 +                               *
      |
    4 +                       *
      |
    3 +
      |
    2 +               *
      |
    1 +       *
      |
    --+-------+-------+-------+-------+-------+-------+-------+-------+-->
    O |       1       2       3       4       5       6       7       8

Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false

Constraints:

    2 <= coordinates.length <= 1000
    coordinates[i].length == 2
    -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
    coordinates contains no duplicate point.

 */

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        for (int i = 0; i < coordinates.length - 2; ++i) {
            int x0 = coordinates[i][0];
            int y0 = coordinates[i][1];
            int x1 = coordinates[i + 1][0];
            int y1 = coordinates[i + 1][1];
            int x2 = coordinates[i + 2][0];
            int y2 = coordinates[i + 2][1];
            int dx1 = x1 - x0;
            int dy1 = y1 - y0;
            int dx2 = x2 - x1;
            int dy2 = y2 - y1;
            if (dx1 * dy2 != dy1 * dx2) {
                return false;
            }
        }
        return true;
    }
}

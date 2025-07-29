package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._1._4._9;

/*

https://leetcode.com/problems/max-points-on-a-line

149. Max Points on a Line
(Hard)

Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.

Example 1:

      ^
    4 +
      |
    3 +                      (*)
      |
    2 +              (*)
      |
    1 +      (*)
      |
    --+-------+-------+-------+-------+-->
    O |       1       2       3       4

Input: points = [[1,1],[2,2],[3,3]]
Output: 3

Example 2:

      ^
    5 +
      |
    4 +      (*)
      |
    3 +              (*)                      *
      |
    2 +                      (*)
      |
    1 +       *                      (*)
      |
    --+-------+-------+-------+-------+-------+-->
    O |       1       2       3       4       5

Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4

Constraints:

    1 <= points.length <= 300
    points[i].length == 2
    -10^4 <= xi, yi <= 10^4
    All the points are unique.

 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int maxPoints(int[][] points) {
        int max = 0;
        for (int i = 0; i < points.length; ++i) {
            Map<List<Integer>, Integer> slopeFreq = new HashMap<>();
            int[] current = points[i];
            int currentX = current[0];
            int currentY = current[1];
            for (int j = i + 1; j < points.length; ++j) {
                int[] other = points[j];
                int otherX = other[0];
                int otherY = other[1];
                int deltaX = otherX - currentX;
                int deltaY = otherY - currentY;
                List<Integer> slope = slope(deltaX, deltaY);
                slopeFreq.put(slope, slopeFreq.getOrDefault(slope, 0) + 1);
            }
            int currentMax = slopeFreq.values().stream().mapToInt(count -> count).max().orElse(0) + 1;
            max = Math.max(max, currentMax);
        }
        return max;
    }

    private int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        int temp;
        while (b > 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private List<Integer> slope(int deltaX, int deltaY) {
        if (deltaX == 0) {
            return Arrays.asList(0, 1);
        }
        if (deltaY == 0) {
            return Arrays.asList(1, 0);
        }
        int gcd = gcd(deltaX, deltaY);
        deltaX /= gcd;
        deltaY /= gcd;
        if (deltaX < 0) {
            deltaX *= -1;
            deltaY *= -1;
        }
        return Arrays.asList(deltaX, deltaY);
    }
}

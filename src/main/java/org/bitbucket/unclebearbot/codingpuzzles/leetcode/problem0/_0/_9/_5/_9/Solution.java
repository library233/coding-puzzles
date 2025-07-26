package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._9._5._9;

/*

https://leetcode.com/problems/regions-cut-by-slashes

959. Regions Cut By Slashes
(Medium)

An n x n grid is composed of 1 x 1 squares where each 1 x 1 square consists of a '/', '\', or blank space ' '. These characters divide the square into contiguous regions.

Given the grid `grid` represented as a string array, return the number of regions.

Note that backslash characters are escaped, so a '\' is represented as '\\'.

Example 1:

    +------*
    |    / |
    | /    |
    *------+

Input: grid = [" /","/ "]
Output: 2

Example 2:

    +------*
    |    / |
    |      |
    +------+

Input: grid = [" /","  "]
Output: 1

Example 3:

    +------+
    | /  \ |
    | \  / |
    +------+

Input: grid = ["/\\","\\/"]
Output: 5
Explanation: Recall that because \ characters are escaped, "\\/" refers to \/, and "/\\" refers to /\.

Constraints:

    n == grid.length == grid[i].length
    1 <= n <= 30
    grid[i][j] is either '/', '\', or ' '.

 */

import java.util.stream.IntStream;

class Solution {
    private int[] ancestors;

    public int regionsBySlashes(String[] grid) {
        int sideLength = grid.length;
        int rectangles = (int) Math.pow(sideLength, 2);
        int triangles = rectangles * 4;
        ancestors = IntStream.range(0, triangles).toArray();
        for (int line = 0; line < sideLength; ++line) {
            for (int column = 0; column < sideLength; ++column) {
                char c = grid[line].charAt(column);
                int rectangle = (line * sideLength + column) * 4;
                int northTriangle = rectangle + 0;
                int eastTriangle = rectangle + 1;
                int southTriangle = rectangle + 2;
                int westTriangle = rectangle + 3;
                switch (c) {
                    case '/':
                        unionAncestors(eastTriangle, southTriangle);
                        unionAncestors(westTriangle, northTriangle);
                        break;
                    case '\\':
                        unionAncestors(northTriangle, eastTriangle);
                        unionAncestors(southTriangle, westTriangle);
                        break;
                    case ' ':
                        unionAncestors(northTriangle, eastTriangle);
                        unionAncestors(eastTriangle, southTriangle);
                        unionAncestors(southTriangle, westTriangle);
                        break;
                    default:
                        throw new IllegalStateException();
                }
                if (column + 1 < sideLength) {
                    int eastRectangle = rectangle + 4;
                    int westTriangleOfEastRectangle = eastRectangle + 3;
                    unionAncestors(eastTriangle, westTriangleOfEastRectangle);
                }
                if (line + 1 < sideLength) {
                    int southRectangle = rectangle + sideLength * 4;
                    int northTriangleOfSouthRectangle = southRectangle + 0;
                    unionAncestors(southTriangle, northTriangleOfSouthRectangle);
                }
            }
        }
        return (int) countConnectedComponents();
    }

    private void unionAncestors(int triangle1, int triangle2) {
        int ancestor1 = findAncestor(triangle1);
        int ancestor2 = findAncestor(triangle2);
        ancestors[ancestor1] = ancestor2;
    }

    private int findAncestor(int triangle) {
        int parent = ancestors[triangle];
        if (parent != triangle) {
            int grandparent = findAncestor(parent);
            ancestors[triangle] = grandparent;
        }
        return ancestors[triangle];
    }

    private long countConnectedComponents() {
        return IntStream.range(0, ancestors.length).filter(i -> findAncestor(i) == i).count();
    }
}

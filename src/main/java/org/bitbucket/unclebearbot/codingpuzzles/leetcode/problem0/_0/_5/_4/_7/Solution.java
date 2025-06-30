package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._5._4._7;

/*

https://leetcode.com/problems/number-of-provinces

547. Number of Provinces
(Medium)

There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

Example 1:

    [1]---[2]
       (3)

Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2

Example 2:

    (1)   (2)
       (3)

Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3

Constraints:

    1 <= n <= 200
    n == isConnected.length
    n == isConnected[i].length
    isConnected[i][j] is 1 or 0.
    isConnected[i][i] == 1
    isConnected[i][j] == isConnected[j][i]

 */

import java.util.stream.IntStream;

class Solution {
    private int[] ancestors;

    public int findCircleNum(int[][] isConnected) {
        int length = isConnected.length;
        ancestors = IntStream.range(0, length).toArray();
        IntStream.range(0, length).forEach(i -> IntStream.range(i + 1, length).filter(j -> isConnected[i][j] == 1).forEach(j -> unionAncestors(i, j)));
        return (int) countConnectedComponents();
    }

    private void unionAncestors(int city1, int city2) {
        int ancestor1 = findAncestor(city1);
        int ancestor2 = findAncestor(city2);
        ancestors[ancestor1] = ancestor2;
    }

    private int findAncestor(int city) {
        int parent = ancestors[city];
        if (parent != city) {
            int grandparent = findAncestor(parent);
            ancestors[city] = grandparent;
        }
        return ancestors[city];
    }

    private long countConnectedComponents() {
        return IntStream.range(0, ancestors.length).filter(i -> findAncestor(i) == i).count();
    }
}

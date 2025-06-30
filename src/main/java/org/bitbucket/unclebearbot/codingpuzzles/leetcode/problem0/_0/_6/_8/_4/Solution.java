package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._6._8._4;

/*

https://leetcode.com/problems/redundant-connection

684. Redundant Connection
(Medium)

In this problem, a tree is an undirected graph that is connected and has no cycles.

You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.

Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.

Example 1:

    (1)---(2)
     |  /
    (3)

Input: edges = [[1,2],[1,3],[2,3]]
Output: [2,3]

Example 2:

    (2)---(1)---(5)
     |     |
    (3)---(4)

Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
Output: [1,4]

Constraints:

    n == edges.length
    3 <= n <= 1000
    edges[i].length == 2
    1 <= ai < bi <= edges.length
    ai != bi
    There are no repeated edges.
    The given graph is connected.

 */

import java.util.stream.IntStream;

class Solution {
    private int[] ancestors;

    public int[] findRedundantConnection(int[][] edges) {
        ancestors = IntStream.rangeClosed(0, edges.length).toArray();
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            int ancestor1 = findAncestor(node1);
            int ancestor2 = findAncestor(node2);
            if (ancestor1 == ancestor2) {
                return edge;
            }
            union(ancestor1, ancestor2);
        }
        return null;
    }

    private void union(int node1, int node2) {
        ancestors[node1] = node2;
    }

    private int findAncestor(int node) {
        int parent = ancestors[node];
        if (parent != node) {
            int grandparent = findAncestor(parent);
            ancestors[node] = grandparent;
        }
        return ancestors[node];
    }
}

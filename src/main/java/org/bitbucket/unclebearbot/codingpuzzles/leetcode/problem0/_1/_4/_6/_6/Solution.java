package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._1._4._6._6;

/*

https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero

1466. Reorder Routes to Make All Paths Lead to the City Zero
(Medium)

There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.

Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.

This year, there will be a big event in the capital (city 0), and many people want to travel to this city.

Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.

It's guaranteed that each city can reach city 0 after reorder.

Example 1:

         <-----*------
     (1) ------X-----> (3) <------------ (2)
    | ^
    | |
    * X
    | |
    V |
     [0] <------------ (4) ------X-----> (5)
                           <-----*------

Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
Output: 3
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).

Example 2:

    [0] <------------ (1) ------X-----> (2) <------------ (3) ------X-----> (4)
                          <-----*------                       <-----*------

Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
Output: 2
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).

Example 3:

     (1)
      |
      |
      |
      |
      V
     [0] <------------ (2)

Input: n = 3, connections = [[1,0],[2,0]]
Output: 0

Constraints:

    2 <= n <= 5 * 10^4
    connections.length == n - 1
    connections[i].length == 2
    0 <= ai, bi <= n - 1
    ai != bi

 */

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Map.Entry<Integer, Boolean>>> oneDirectionWays = IntStream.range(0, n).mapToObj(i -> new ArrayList<Map.Entry<Integer, Boolean>>()).collect(Collectors.toList());
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            oneDirectionWays.get(from).add(new AbstractMap.SimpleImmutableEntry<>(to, false));
            oneDirectionWays.get(to).add(new AbstractMap.SimpleImmutableEntry<>(from, true));
        }
        return walkThrough(oneDirectionWays, new boolean[n], 0);
    }

    private int walkThrough(List<List<Map.Entry<Integer, Boolean>>> ways, boolean[] visited, int city) {
        int needToReverse = 0;
        visited[city] = true;
        List<Map.Entry<Integer, Boolean>> otherCitiesWithDirections = ways.get(city);
        for (Map.Entry<Integer, Boolean> way : otherCitiesWithDirections) {
            int otherCity = way.getKey();
            if (visited[otherCity]) {
                continue;
            }
            boolean reversed = way.getValue();
            if (!reversed) {
                ++needToReverse;
            }
            needToReverse += walkThrough(ways, visited, otherCity);
        }
        return needToReverse;
    }
}

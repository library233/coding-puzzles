package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._7._8._7;

/*

https://leetcode.com/problems/cheapest-flights-within-k-stops

787. Cheapest Flights Within K Stops
(Medium)

There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

Example 1:

         100
(0) <------------ (2)
 |        +----->  |
 |        |        |
 |[100]   |100     |200
 |        |        |
 V  ------+        V
(1) ------------> (3)
        [600]

Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 700
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.

Example 2:

         500
(0) ---------------+
 |                 |
 |                 |
 |[100]            |
 |                 |
 V                 V
(1) ------------> (2)
        [100]

Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
Output: 200
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.

Example 3:

        [500]
(0) ---------------+
 |                 |
 |                 |
 |100              |
 |                 |
 V                 V
(1) ------------> (2)
        100

Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
Output: 500
Explanation:
The graph is shown above.
The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.

Constraints:

    1 <= n <= 100
    0 <= flights.length <= (n * (n - 1) / 2)
    flights[i].length == 3
    0 <= fromi, toi < n
    fromi != toi
    1 <= pricei <= 10^4
    There will not be any multiple flights between two cities.
    0 <= src, dst, k < n
    src != dst

 */

import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = IntStream.range(0, n).map(i -> Integer.MAX_VALUE).toArray();
        prices[src] = 0;
        for (int i = 0; i < k + 1; ++i) {
            int[] draft = Arrays.copyOf(prices, prices.length);
            boolean foundAnyUsefulEdge = false;
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];
                if (prices[from] == Integer.MAX_VALUE) {
                    continue;
                }
                int priceByThisWay = prices[from] + price;
                if (priceByThisWay < draft[to]) {
                    draft[to] = priceByThisWay;
                    foundAnyUsefulEdge = true;
                }
            }
            prices = draft;
            if (!foundAnyUsefulEdge) {
                break;
            }
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}

package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._9._1._4;

/*

https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards

914. X of a Kind in a Deck of Cards
(Easy)

You are given an integer array deck where deck[i] represents the number written on the ith card.

Partition the cards into one or more groups such that:

    Each group has exactly x cards where x > 1, and
    All the cards in one group have the same integer written on them.

Return true if such partition is possible, or false otherwise.

Example 1:

Input: deck = [1,2,3,4,4,3,2,1]
Output: true
Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].

Example 2:

Input: deck = [1,1,1,2,2,2,3,3]
Output: false
Explanation: No possible partition.

Constraints:

    1 <= deck.length <= 10^4
    0 <= deck[i] < 10^4

 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length < 2) {
            return false;
        }
        Map<Integer, Integer> cardsToCounts = new HashMap<>();
        Arrays.stream(deck).forEach(card -> cardsToCounts.put(card, cardsToCounts.getOrDefault(card, 0) + 1));
        int gcd = 0;
        for (int count : cardsToCounts.values()) {
            gcd = greatestCommonDivisor(gcd, count);
            if (gcd == 1) {
                return false;
            }
        }
        return gcd >= 2;
    }

    private int greatestCommonDivisor(int a, int b) {
        while (a != 0) {
            int mod = b % a;
            b = a;
            a = mod;
        }
        return b;
    }
}

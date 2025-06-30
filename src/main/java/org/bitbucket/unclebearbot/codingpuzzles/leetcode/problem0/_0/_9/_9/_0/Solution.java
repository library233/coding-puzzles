package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._9._9._0;

/*

https://leetcode.com/problems/satisfiability-of-equality-equations

990. Satisfiability of Equality Equations
(Medium)

You are given an array of strings equations that represent relationships between variables where each string equations[i] is of length 4 and takes one of two different forms: "xi==yi" or "xi!=yi".Here, xi and yi are lowercase letters (not necessarily different) that represent one-letter variable names.

Return true if it is possible to assign integers to variable names so as to satisfy all the given equations, or false otherwise.

Example 1:

Input: equations = ["a==b","b!=a"]
Output: false
Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.
There is no way to assign the variables to satisfy both equations.

Example 2:

Input: equations = ["b==a","a==b"]
Output: true
Explanation: We could assign a = 1 and b = 1 to satisfy both equations.

Constraints:

    1 <= equations.length <= 500
    equations[i].length == 4
    equations[i][0] is a lowercase letter.
    equations[i][1] is either '=' or '!'.
    equations[i][2] is '='.
    equations[i][3] is a lowercase letter.

 */

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

class Solution {
    private int[] ancestors;

    public boolean equationsPossible(String[] equations) {
        ancestors = IntStream.range(0, 26).toArray();
        Arrays.stream(equations).filter(this::isPositive).forEach(this::unionLetters);
        return Arrays.stream(equations).filter(this::isNegative).noneMatch(this::isEqualAncestor);
    }

    private boolean isPositive(String equation) {
        return equation.charAt(1) == '=';
    }

    private boolean isNegative(String equation) {
        return equation.charAt(1) == '!';
    }

    private void unionLetters(String positiveEquation) {
        int x = indexX(positiveEquation);
        int y = indexY(positiveEquation);
        unionAncestors(x, y);
    }

    private boolean isEqualAncestor(String negativeEquation) {
        int x = indexX(negativeEquation);
        int y = indexY(negativeEquation);
        int ancestorX = findAncestor(x);
        int ancestorY = findAncestor(y);
        return ancestorX == ancestorY;
    }

    private int indexX(String equation) {
        return index(equation, 0);
    }

    private int indexY(String equation) {
        return index(equation, 3);
    }

    private int index(String equation, int charAt) {
        return Optional.of(charAt).map(equation::charAt).map(c -> c - 'a').orElseThrow(IllegalStateException::new);
    }

    private void unionAncestors(int letter1, int letter2) {
        int ancestor1 = findAncestor(letter1);
        int ancestor2 = findAncestor(letter2);
        ancestors[ancestor1] = ancestor2;
    }

    private int findAncestor(int letter) {
        int parent = ancestors[letter];
        if (parent != letter) {
            int grandparent = findAncestor(parent);
            ancestors[letter] = grandparent;
        }
        return ancestors[letter];
    }
}

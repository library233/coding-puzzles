package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._6._0._5;

/*

https://leetcode.com/problems/can-place-flowers

605. Can Place Flowers
(Easy)

You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.

Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: true

Example 2:

Input: flowerbed = [1,0,0,0,1], n = 2
Output: false

Constraints:

    1 <= flowerbed.length <= 2 * 10^4
    flowerbed[i] is 0 or 1.
    There are no two adjacent flowers in flowerbed.
    0 <= n <= flowerbed.length

 */

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        for (int i = 0; i < flowerbed.length; ++i) {
            if (isValid(flowerbed, i)) {
                flowerbed[i] = 1;
                --n;
            }
            if (n == 0) {
                return true;
            }
        }
        return false;
    }

    private boolean isValid(int[] flowerbed, int index) {
        return isCurrentEmpty(flowerbed, index) && isLeftEmpty(flowerbed, index) && isRightEmpty(flowerbed, index);
    }

    private boolean isCurrentEmpty(int[] flowerbed, int index) {
        return isEmpty(flowerbed[index]);
    }

    private boolean isLeftEmpty(int[] flowerbed, int index) {
        return index == 0 || isEmpty(flowerbed[index - 1]);
    }

    private boolean isRightEmpty(int[] flowerbed, int index) {
        return index == flowerbed.length - 1 || isEmpty(flowerbed[index + 1]);
    }

    private boolean isEmpty(int i) {
        return i == 0;
    }
}

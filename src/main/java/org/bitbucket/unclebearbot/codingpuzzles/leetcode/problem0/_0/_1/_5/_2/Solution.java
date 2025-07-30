package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._1._5._2;

/*

https://leetcode.com/problems/maximum-product-subarray

152. Maximum Product Subarray
(Medium)

Given an integer array nums, find a subarray that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

Constraints:

    1 <= nums.length <= 2 * 10^4
    -10 <= nums[i] <= 10
    The product of any subarray of nums is guaranteed to fit in a 32-bit integer.

 */

class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        int minWindowProduct = 1;
        int maxWindowProduct = 1;
        for (int num : nums) {
            if (num < 0) {
                int temp = minWindowProduct;
                minWindowProduct = maxWindowProduct;
                maxWindowProduct = temp;
            }
            minWindowProduct = Math.min(minWindowProduct * num, num);
            maxWindowProduct = Math.max(maxWindowProduct * num, num);
            maxProduct = Math.max(maxProduct, maxWindowProduct);
        }
        return maxProduct;
    }
}

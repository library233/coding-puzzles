package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._1._0._8;

/*

https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree

108. Convert Sorted Array to Binary Search Tree
(Easy)

Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

Example 1:

             (0)                    (0)
            /   \                  /   \
        (-3)     (9)    or    (-10)     (5)
        /        /                \       \
    (-10)      (5)                (-3)    (9)

Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:

      (3)          (1)
      /      or      \
    (1)              (3)

Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.

Constraints:

    1 <= nums.length <= 10^4
    -10^4 <= nums[i] <= 10^4
    nums is sorted in a strictly increasing order.

 */

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return mid(nums, 0, nums.length - 1);
    }

    private TreeNode mid(int[] nums, int begin, int end) {
        if (begin > end) {
            return null;
        }
        int mid = (begin + end) / 2;
        int value = nums[mid];
        TreeNode left = mid(nums, begin, mid - 1);
        TreeNode right = mid(nums, mid + 1, end);
        return new TreeNode(value, left, right);
    }
}

/**
 * Definition for a binary tree node.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

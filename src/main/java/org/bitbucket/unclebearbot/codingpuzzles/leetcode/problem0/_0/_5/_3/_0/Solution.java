package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._5._3._0;

/*

https://leetcode.com/problems/minimum-absolute-difference-in-bst

530. Minimum Absolute Difference in BST
(Easy)

Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.

Example 1:

        (4)
        / \
      (2) (6)
      / \
    (1) (3)

Input: root = [4,2,6,1,3]
Output: 1

Example 2:

      (1)
      / \
    (0) (48)
        /  \
     (12)  (49)

Input: root = [1,0,48,null,null,12,49]
Output: 1

Constraints:

    The number of nodes in the tree is in the range [2, 10^4].
    0 <= Node.val <= 10^5

Note: This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/

 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        Stack<TreeNode> inorder = new Stack<>();
        TreeNode node = root;
        while (node != null || !inorder.isEmpty()) {
            while (node != null) {
                inorder.push(node);
                node = node.left;
            }
            node = inorder.pop();
            values.add(node.val);
            node = node.right;
        }
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < values.size(); ++i) {
            minDiff = Math.min(minDiff, Math.abs(values.get(i) - values.get(i - 1)));
        }
        return minDiff;
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

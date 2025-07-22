package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._1._0._0;

/*

https://leetcode.com/problems/same-tree

100. Same Tree
(Easy)

Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

Example 1:

      (1)        (1)
      / \        / \
    (2) (3)    (2) (3)

Input: p = [1,2,3], q = [1,2,3]
Output: true

Example 2:

      (1)    (1)
      /        \
    (2)        (2)

Input: p = [1,2], q = [1,null,2]
Output: false

Example 3:

      (1)        (1)
      / \        / \
    (2) (1)    (1) (2)

Input: p = [1,2,1], q = [1,1,2]
Output: false

Constraints:

    The number of nodes in both trees is in the range [0, 100].
    -10^4 <= Node.val <= 10^4

 */

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
            if (!isSameTree(p.left, q.left)) {
                return false;
            }
            if (!isSameTree(p.right, q.right)) {
                return false;
            }
            return true;
        }
        return false;
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

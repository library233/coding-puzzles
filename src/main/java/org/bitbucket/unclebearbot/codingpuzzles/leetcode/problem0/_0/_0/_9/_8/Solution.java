package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._9._8;

/*

https://leetcode.com/problems/validate-binary-search-tree

98. Validate Binary Search Tree
(Medium)

Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

Example 1:

      (2)
      / \
    (1) (3)

Input: root = [2,1,3]
Output: true

Example 2:

      (5)
      / \
    (1) (4)
        / \
      (3) (6)

Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.

Constraints:

    The number of nodes in the tree is in the range [1, 10^4].
    -2^31 <= Node.val <= 2^31 - 1

 */

import java.util.Stack;

class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> inorder = new Stack<>();
        TreeNode node = root;
        long last = Long.MIN_VALUE;
        while (node != null || !inorder.isEmpty()) {
            while (node != null) {
                inorder.push(node);
                node = node.left;
            }
            node = inorder.pop();
            if (node.val <= last) {
                return false;
            }
            last = node.val;
            node = node.right;
        }
        return true;
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

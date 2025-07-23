package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._1._1._4;

/*

https://leetcode.com/problems/flatten-binary-tree-to-linked-list

114. Flatten Binary Tree to Linked List
(Medium)

Given the root of a binary tree, flatten the tree into a "linked list":

    The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
    The "linked list" should be in the same order as a pre-order traversal of the binary tree.

Example 1:

        (1)              (1)
        / \                \
      (2) (5)      ->      (2)
      / \   \                \
    (3) (4) (6)              (3)
                               \
                               (4)
                                 \
                                 (5)
                                   \
                                   (6)

Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]

Example 2:

Input: root = []
Output: []

Example 3:

Input: root = [0]
Output: [0]

Constraints:

    The number of nodes in the tree is in the range [0, 2000].
    -100 <= Node.val <= 100

Follow up: Can you flatten the tree in-place (with O(1) extra space)?

 */

class Solution {
    public void flatten(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                TreeNode insert = current.left;
                while (insert.right != null) {
                    insert = insert.right;
                }
                insert.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
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

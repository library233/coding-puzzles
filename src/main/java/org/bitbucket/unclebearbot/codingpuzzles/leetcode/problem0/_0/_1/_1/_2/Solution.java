package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._1._1._2;

/*

https://leetcode.com/problems/path-sum

112. Path Sum
(Easy)

Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.

Example 1:

             [5]
            /   \
         [4]     (8)
         /       / \
      [11]    (13) (4)
      /  \           \
    (7)  [2]         (1)

Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.

Example 2:

      (1)
      / \
    (2) (3)

Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There are two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.

Example 3:

Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths.

Constraints:

    The number of nodes in the tree is in the range [0, 5000].
    -1000 <= Node.val <= 1000
    -1000 <= targetSum <= 1000

 */

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        int remain = targetSum - root.val;
        if (root.left == null && root.right == null) {
            return remain == 0;
        }
        if (hasPathSum(root.left, remain)) {
            return true;
        }
        if (hasPathSum(root.right, remain)) {
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

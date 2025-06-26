package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem00437;

/*

https://leetcode.com/problems/path-sum-iii

437. Path Sum III
(Medium)

Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.

The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).

Example 1:

              (10)
             /    \
          (5)      (-3)
         /   \        \
      (3)     (2)     (11)
      / \       \
    (3) (-2)    (1)

Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3

    (5) -> (3)
    (5) -> (2) -> (1)
    (-3) -> (11)

Explanation: The paths that sum to 8 are shown.

Example 2:

             (5)
            /   \
         (4)     (8)
         /       / \
      (11)    (13) (4)
      /  \         / \
    (7)  (2)     (5) (1)

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: 3

    (5) -> (4) -> (11) -> (2)
    (4) -> (11) -> (7)
    (5) -> (8) -> (4) -> (5)

Constraints:

    The number of nodes in the tree is in the range [0, 1000].
    -10^9 <= Node.val <= 10^9
    -1000 <= targetSum <= 1000

 */

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        return countBothDirectAndIndirectPaths(root, targetSum);
    }

    private int countBothDirectAndIndirectPaths(TreeNode ancestor, int targetSum) {
        int result = 0;
        if (ancestor == null) {
            return result;
        }
        result += countOnlyDirectPaths(ancestor, targetSum);
        result += countBothDirectAndIndirectPaths(ancestor.left, targetSum);
        result += countBothDirectAndIndirectPaths(ancestor.right, targetSum);
        return result;
    }

    private int countOnlyDirectPaths(TreeNode directAncestor, long targetSum) {
        int result = 0;
        if (directAncestor == null) {
            return result;
        }
        long remain = targetSum - directAncestor.val;
        if (remain == 0) {
            ++result;
        }
        result += countOnlyDirectPaths(directAncestor.left, remain);
        result += countOnlyDirectPaths(directAncestor.right, remain);
        return result;
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

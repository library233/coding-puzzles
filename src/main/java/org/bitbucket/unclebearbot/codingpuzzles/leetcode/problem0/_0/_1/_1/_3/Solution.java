package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._1._1._3;

/*

https://leetcode.com/problems/path-sum-ii

113. Path Sum II
(Medium)

Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

Example 1:

             [5]
            /   \
         [4]     [8]
         /       / \
      [11]    (13) [4]
      /  \         / \
    (7)  [2]     [5] (1)

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22

Example 2:

      (1)
      / \
    (2) (3)

Input: root = [1,2,3], targetSum = 5
Output: []

Example 3:

      (1)
      /
    (2)

Input: root = [1,2], targetSum = 0
Output: []

Constraints:

    The number of nodes in the tree is in the range [0, 5000].
    -1000 <= Node.val <= 1000
    -1000 <= targetSum <= 1000

 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        return walkThrough(root, targetSum, new ArrayList<>(), new ArrayList<>());
    }

    private List<List<Integer>> walkThrough(TreeNode node, int targetSum, List<Integer> path, List<List<Integer>> result) {
        if (node == null) {
            return result;
        }
        path.add(node.val);
        int remain = targetSum - node.val;
        if (node.left == null && node.right == null && remain == 0) {
            result.add(new ArrayList<>(path));
        } else {
            walkThrough(node.left, remain, path, result);
            walkThrough(node.right, remain, path, result);
        }
        path.remove(path.size() - 1);
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

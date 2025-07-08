package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._8._7._2;

/*

https://leetcode.com/problems/leaf-similar-trees

872. Leaf-Similar Trees
(Easy)

Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.

          (3)
         /   \
      (5)     (1)
      / \     / \
    [6] (2) [9] [8]
        / \
      [7] [4]

For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

Example 1:

          (3)                (3)
         /   \              /   \
      (5)     (1)        (5)     (1)
      / \     / \        / \     / \
    [6] (2) [9] [8]    [6] [7] [4] (2)
        / \                        / \
      [7] [4]                    [9] [8]

Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
Output: true

Example 2:

      (1)        (1)
      / \        / \
    [2] [3]    [3] [2]

Input: root1 = [1,2,3], root2 = [1,3,2]
Output: false

Constraints:

    The number of nodes in each tree will be in the range [1, 200].
    Both of the given trees will have values in the range [0, 200].

 */

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = getLeaves(root1);
        List<Integer> leaves2 = getLeaves(root2);
        return Objects.equals(leaves1, leaves2);
    }

    private List<Integer> getLeaves(TreeNode node) {
        List<Integer> leaves = new ArrayList<>();
        collectLeaves(node, leaves);
        return leaves;
    }

    private void collectLeaves(TreeNode node, List<Integer> leaves) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
            return;
        }
        collectLeaves(node.left, leaves);
        collectLeaves(node.right, leaves);
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

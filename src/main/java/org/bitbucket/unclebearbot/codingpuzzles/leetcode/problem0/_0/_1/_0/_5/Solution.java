package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._1._0._5;

/*

https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal

105. Construct Binary Tree from Preorder and Inorder Traversal
(Medium)

Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

Example 1:

      (3)
      / \
    (9) (20)
        /  \
     (15)  (7)

Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]

Constraints:

    1 <= preorder.length <= 3000
    inorder.length == preorder.length
    -3000 <= preorder[i], inorder[i] <= 3000
    preorder and inorder consist of unique values.
    Each value of inorder also appears in preorder.
    preorder is guaranteed to be the preorder traversal of the tree.
    inorder is guaranteed to be the inorder traversal of the tree.

 */

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> valuesToInorderIndices = IntStream.range(0, inorder.length).boxed().collect(Collectors.toMap(i -> inorder[i], Function.identity(), (a, b) -> b));
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, valuesToInorderIndices);
    }

    private TreeNode buildTree(int[] preorder, int preorderBegin, int preorderEnd, int[] inorder, int inorderBegin, int inorderEnd, Map<Integer, Integer> valuesToInorderIndices) {
        if (preorderBegin > preorderEnd || inorderBegin > inorderEnd) {
            return null;
        }
        int rootValue = preorder[preorderBegin];
        int rootInorderIndex = valuesToInorderIndices.get(rootValue);
        int leftNodeCount = rootInorderIndex - inorderBegin;
        TreeNode left = buildTree(preorder, preorderBegin + 1, preorderBegin + leftNodeCount, inorder, inorderBegin, rootInorderIndex - 1, valuesToInorderIndices);
        TreeNode right = buildTree(preorder, preorderBegin + leftNodeCount + 1, preorderEnd, inorder, rootInorderIndex + 1, inorderEnd, valuesToInorderIndices);
        return new TreeNode(rootValue, left, right);
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

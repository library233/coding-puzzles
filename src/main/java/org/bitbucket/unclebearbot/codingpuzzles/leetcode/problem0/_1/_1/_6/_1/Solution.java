package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._1._1._6._1;

/*

https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree

1161. Maximum Level Sum of a Binary Tree
(Medium)

Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level x such that the sum of all the values of nodes at level x is maximal.

Example 1:

        (1)
        / \
      [7] [0]
      / \
    (7) (-8)

Input: root = [1,7,0,7,-8,null,null]
Output: 2
Explanation:
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.

Example 2:

      (989)
          \
          [10250]
          /     \
    (98693)     (-89388)
                       \
                       (-32127)

Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
Output: 2

Constraints:

    The number of nodes in the tree is in the range [1, 10^4].
    -10^5 <= Node.val <= 10^5

 */

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int result = 0;
        int maxSum = Integer.MIN_VALUE;
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            AtomicInteger sum = new AtomicInteger();
            IntStream.range(0, queue.size()).mapToObj(i -> queue.poll()).forEach(node -> {
                sum.addAndGet(node.val);
                Optional.ofNullable(node.left).ifPresent(queue::offer);
                Optional.ofNullable(node.right).ifPresent(queue::offer);
            });
            if (sum.get() > maxSum) {
                maxSum = sum.get();
                result = level;
            }
            ++level;
        }
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

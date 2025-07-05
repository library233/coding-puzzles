package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._3._1._5;

/*

https://leetcode.com/problems/count-of-smaller-numbers-after-self

315. Count of Smaller Numbers After Self
(Hard)

Given an integer array nums, return an integer array counts where counts[i] is the number of smaller elements to the right of nums[i].

Example 1:

Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.

Example 2:

Input: nums = [-1]
Output: [0]

Example 3:

Input: nums = [-1,-1]
Output: [0,0]

Constraints:

    1 <= nums.length <= 10^5
    -10^4 <= nums[i] <= 10^4

 */

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> sorted = Arrays.stream(nums).distinct().sorted().boxed().collect(Collectors.toList());
        Map<Integer, Integer> numsToRanks = IntStream.range(0, sorted.size()).boxed().collect(Collectors.toMap(sorted::get, Function.identity(), (a, b) -> b));
        List<Integer> result = new ArrayList<>();
        SegmentTree segmentTree = new SegmentTree(sorted.size());
        for (int i = nums.length - 1; i >= 0; --i) {
            int num = nums[i];
            int rank = numsToRanks.get(num);
            int count = segmentTree.sumAppearanceCountFromZeroAsLeftTo(rank - 1);
            result.add(count);
            segmentTree.increaseAppearanceCount(rank);
        }
        Collections.reverse(result);
        return result;
    }

    private static class SegmentTree {
        private final int[] nodes;
        private final int length;
        private final int root = 1;

        private SegmentTree(int length) {
            this.length = length;
            nodes = new int[4 * length];
        }

        protected void increaseAppearanceCount(int index) {
            update(root, 0, length - 1, index);
        }

        private void update(int node, int nodeRangeBegin, int nodeRangeEnd, int index) {
            if (nodeRangeBegin == nodeRangeEnd) {
                ++nodes[node];
                return;
            }
            int leftChild = 2 * node;
            int rightChild = 2 * node + 1;
            int midNode = (nodeRangeBegin + nodeRangeEnd) / 2;
            if (index <= midNode) {
                update(leftChild, nodeRangeBegin, midNode, index);
            } else {
                update(rightChild, midNode + 1, nodeRangeEnd, index);
            }
            nodes[node] = nodes[leftChild] + nodes[rightChild];
        }

        protected int sumAppearanceCountFromZeroAsLeftTo(int right) {
            return query(root, 0, length - 1, 0, right);
        }

        private int query(int node, int nodeRangeBegin, int nodeRangeEnd, int queryRangeLeft, int queryRangeRight) {
            if (queryRangeLeft > nodeRangeEnd) {
                return 0;
            }
            if (queryRangeRight < nodeRangeBegin) {
                return 0;
            }
            if (queryRangeLeft <= nodeRangeBegin && queryRangeRight >= nodeRangeEnd) {
                return nodes[node];
            }
            int leftChild = 2 * node;
            int rightChild = 2 * node + 1;
            int midNode = (nodeRangeBegin + nodeRangeEnd) / 2;
            int leftSum = query(leftChild, nodeRangeBegin, midNode, queryRangeLeft, queryRangeRight);
            int rightSum = query(rightChild, midNode + 1, nodeRangeEnd, queryRangeLeft, queryRangeRight);
            return leftSum + rightSum;
        }
    }
}

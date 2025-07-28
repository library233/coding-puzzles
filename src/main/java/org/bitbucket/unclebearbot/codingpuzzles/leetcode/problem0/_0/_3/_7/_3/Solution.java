package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._3._7._3;

/*

https://leetcode.com/problems/find-k-pairs-with-smallest-sums

373. Find K Pairs with Smallest Sums
(Medium)

You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.

Define a pair (u, v) which consists of one element from the first array and one element from the second array.

Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.

Example 1:

Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]]
Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

Example 2:

Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [[1,1],[1,1]]
Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]

Constraints:

    1 <= nums1.length, nums2.length <= 10^5
    -10^9 <= nums1[i], nums2[i] <= 10^9
    nums1 and nums2 both are sorted in non-decreasing order.
    1 <= k <= 10^4
    k <= nums1.length * nums2.length

 */

import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(list -> list.get(2)));
        Set<List<Integer>> offered = new HashSet<>();
        List<Integer> init = tuple(nums1, 0, nums2, 0);
        offerIfNever(init, minHeap, offered);
        while (!minHeap.isEmpty() && result.size() < k) {
            List<Integer> min = minHeap.poll();
            result.add(min.subList(0, 2));
            int index1 = min.get(3);
            int index2 = min.get(4);
            if (index1 + 1 < nums1.length) {
                List<Integer> next1 = tuple(nums1, index1 + 1, nums2, index2);
                offerIfNever(next1, minHeap, offered);
            }
            if (index2 + 1 < nums2.length) {
                List<Integer> next2 = tuple(nums1, index1, nums2, index2 + 1);
                offerIfNever(next2, minHeap, offered);
            }
        }
        return result;
    }

    private List<Integer> tuple(int[] nums1, int index1, int[] nums2, int index2) {
        List<Integer> result = new ArrayList<>();
        result.add(nums1[index1]);
        result.add(nums2[index2]);
        result.add(nums1[index1] + nums2[index2]);
        result.add(index1);
        result.add(index2);
        return result;
    }

    private void offerIfNever(List<Integer> tuple, Queue<List<Integer>> minHeap, Set<List<Integer>> offered) {
        if (offered.add(tuple)) {
            minHeap.offer(tuple);
        }
    }
}

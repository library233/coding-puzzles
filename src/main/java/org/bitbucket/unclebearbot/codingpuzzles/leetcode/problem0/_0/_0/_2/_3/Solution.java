package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._2._3;

/*

https://leetcode.com/problems/merge-k-sorted-lists

23. Merge k Sorted Lists
(Hard)

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

Example 2:

Input: lists = []
Output: []

Example 3:

Input: lists = [[]]
Output: []

Constraints:

    k == lists.length
    0 <= k <= 10^4
    0 <= lists[i].length <= 500
    -10^4 <= lists[i][j] <= 10^4
    lists[i] is sorted in ascending order.
    The sum of lists[i].length will not exceed 10^4.

 */

import java.util.*;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        Arrays.stream(lists).filter(Objects::nonNull).forEach(queue::offer);
        ListNode start = new ListNode();
        ListNode current = start;
        while (!queue.isEmpty()) {
            ListNode min = queue.poll();
            current.next = min;
            current = current.next;
            Optional.of(min).map(node -> node.next).ifPresent(queue::offer);
        }
        return start.next;
    }
}

/**
 * Definition for singly-linked list.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

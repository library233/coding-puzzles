package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._8._2;

/*

https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii

82. Remove Duplicates from Sorted List II
(Medium)

Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

Example 1:

    (1) -> (2) -> [3] -> [3] -> [4] -> [4] -> (5)

    (1) -> (2) -----------------------------> (5)

Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]

Example 2:

    [1] -> [1] -> [1] -> (2) -> (3)

                         (2) -> (3)

Input: head = [1,1,1,2,3]
Output: [2,3]

Constraints:

    The number of nodes in the list is in the range [0, 300].
    -100 <= Node.val <= 100
    The list is guaranteed to be sorted in ascending order.

 */

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode start = new ListNode(0, head);
        ListNode slow = start;
        ListNode fast = start.next;
        while (fast != null) {
            int current = fast.val;
            if (fast.next == null || fast.next.val != current) {
                slow = slow.next;
                fast = fast.next;
                continue;
            }
            while (fast != null && fast.val == current) {
                fast = fast.next;
            }
            slow.next = fast;
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

package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._8._3;

/*

https://leetcode.com/problems/remove-duplicates-from-sorted-list

83. Remove Duplicates from Sorted List
(Easy)

Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

Example 1:

    (1) -> (1) -> (2)

    (1) -> (2)

Input: head = [1,1,2]
Output: [1,2]

Example 2:

    (1) -> (1) -> (2) -> (3) -> (3)

    (1) -> (2) -> (3)

Input: head = [1,1,2,3,3]
Output: [1,2,3]

Constraints:

    The number of nodes in the list is in the range [0, 300].
    -100 <= Node.val <= 100
    The list is guaranteed to be sorted in ascending order.

 */

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
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

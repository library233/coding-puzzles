package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._1._4._8;

/*

https://leetcode.com/problems/sort-list

148. Sort List
(Medium)

Given the head of a linked list, return the list after sorting it in ascending order.

Example 1:

    (4) -> (2) -> (1) -> (3)

    (1) -> (2) -> (3) -> (4)

Input: head = [4,2,1,3]
Output: [1,2,3,4]

Example 2:

    (-1) -> (5) -> (3) -> (4) -> (0)

    (-1) -> (0) -> (3) -> (4) -> (5)

Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]

Example 3:

Input: head = []
Output: []

Constraints:

    The number of nodes in the list is in the range [0, 5 * 10^4].
    -10^5 <= Node.val <= 10^5

Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?

 */

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode half = null;
        while (fast != null && fast.next != null) {
            half = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        half.next = null;
        ListNode first = sortList(head);
        ListNode second = sortList(slow);
        return merge(first, second);
    }

    private ListNode merge(ListNode first, ListNode second) {
        ListNode start = new ListNode();
        ListNode current = start;
        while (first != null && second != null) {
            if (first.val < second.val) {
                current.next = first;
                first = first.next;
            } else {
                current.next = second;
                second = second.next;
            }
            current = current.next;
        }
        if (first != null) {
            current.next = first;
        } else {
            current.next = second;
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

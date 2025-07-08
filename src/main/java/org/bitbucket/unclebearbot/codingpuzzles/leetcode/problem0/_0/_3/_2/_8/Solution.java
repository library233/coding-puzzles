package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._3._2._8;

/*

https://leetcode.com/problems/odd-even-linked-list

328. Odd Even Linked List
(Medium)

Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.

Example 1:

    (1) -> [2] -> (3) -> [4] -> (5)
    (1) -> (3) -> (5) -> [2] -> [4]

Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]

Example 2:

    (2) -> [1] -> (3) -> [5] -> (6) -> [4] -> (7)
    (2) -> (3) -> (6) -> (7) -> [1] -> [5] -> [4]

Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]

Constraints:

    The number of nodes in the linked list is in the range [0, 10^4].
    -10^6 <= Node.val <= 10^6

 */

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode secondHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = secondHead;
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

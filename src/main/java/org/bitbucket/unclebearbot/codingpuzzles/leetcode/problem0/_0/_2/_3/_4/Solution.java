package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._2._3._4;

/*

https://leetcode.com/problems/palindrome-linked-list

234. Palindrome Linked List
(Easy)

Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

Example 1:

    (1) -> (2) -> (2) -> (1)

Input: head = [1,2,2,1]
Output: true

Example 2:

    (1) -> (2)

Input: head = [1,2]
Output: false

Constraints:

    The number of nodes in the list is in the range [1, 10^5].
    0 <= Node.val <= 9

Follow up: Could you do it in O(n) time and O(1) space?

 */

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalfHead = slow.next;
        ListNode reversedSecondHalfHead = null;
        ListNode current = secondHalfHead;
        while (current != null) {
            ListNode currentNext = current.next;
            current.next = reversedSecondHalfHead;
            reversedSecondHalfHead = current;
            current = currentNext;
        }
        ListNode firstScanner = head;
        ListNode secondScanner = reversedSecondHalfHead;
        while (secondScanner != null) {
            if (firstScanner.val != secondScanner.val) {
                return false;
            }
            firstScanner = firstScanner.next;
            secondScanner = secondScanner.next;
        }
        return true;
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

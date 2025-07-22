package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._8._6;

/*

https://leetcode.com/problems/partition-list

86. Partition List
(Medium)

Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example 1:

    (1) -> [4] -> [3] -> (2) -> [5] -> (2)

    (1) -> (2) -> (2) -> [4] -> [3] -> [5]
    `````````````````    `````````````````

Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]

Example 2:

Input: head = [2,1], x = 2
Output: [1,2]

Constraints:

    The number of nodes in the list is in the range [0, 200].
    -100 <= Node.val <= 100
    -200 <= x <= 200

 */

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode firstStart = new ListNode();
        ListNode secondStart = new ListNode();
        ListNode first = firstStart;
        ListNode second = secondStart;
        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                first.next = current;
                first = first.next;
            } else {
                second.next = current;
                second = second.next;
            }
            current = current.next;
        }
        first.next = secondStart.next;
        second.next = null;
        return firstStart.next;
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

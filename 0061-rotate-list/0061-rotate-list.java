/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        if (k == 0) {
            return head;
        }
        ListNode temp = head;
        int c = 1;
        while (temp.next != null) {
            temp = temp.next;
            c++;
        }
        ListNode last = temp;
        if (k == c) {
            return head;
        }
        if (k > c) {
            k = k % c;
        }
        if (k == 0) {
            return head;
        }
        int t = c - k - 1;
        ListNode temp2 = head;
        while (t > 0) {
            temp2 = temp2.next;
            t--;
        }
        ListNode newHead = temp2.next;
        temp2.next = null;
        last.next = head;

        return newHead;
    }
}
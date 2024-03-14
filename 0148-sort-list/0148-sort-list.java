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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode temp = mid.next;
        mid.next = null;
        ListNode list2 = temp;
        ListNode left = sortList(head);
        ListNode right = sortList(list2);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                dummy.next = left;
                left = left.next;
                dummy = dummy.next;
            } else {
                dummy.next = right;
                right = right.next;
                dummy = dummy.next;
            }
        }
        while (left != null) {
            dummy.next = left;
            left = left.next;
            dummy = dummy.next;
        }
        while (right != null) {
            dummy.next = right;
            right = right.next;
            dummy = dummy.next;
        }
        return tail.next;
    }

    public ListNode getMid(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
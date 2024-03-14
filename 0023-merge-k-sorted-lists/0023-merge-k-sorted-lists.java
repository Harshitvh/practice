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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0)
        {
            return null;
        }
        return mergeK(lists, 0, lists.length - 1);
    }

    public ListNode mergeK(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode left = mergeK(lists, start, mid);
        ListNode right = mergeK(lists, mid + 1, end);
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
}
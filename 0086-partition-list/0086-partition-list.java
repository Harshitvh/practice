/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode();
        ListNode i1 = dummy;
        ListNode dummy2 = new ListNode();
        ListNode i2 = dummy2;
        ListNode temp = head;
        while(temp!=null)
        {
           if(temp.val<x)
           {
            i1.next = new ListNode(temp.val);
            i1 = i1.next;
           }
           else{
            i2.next = new ListNode(temp.val);
            i2= i2.next;
           }
           temp = temp.next;
        }
        i1.next = dummy2.next;
        return dummy.next;
    }
}
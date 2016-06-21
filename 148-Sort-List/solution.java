/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)   return head;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while(head != null) {
            while(p.next != null && p.next.val < head.val) p = p.next;
            ListNode tmp = head.next;
            head.next = p.next;
            p.next = head;
            head = tmp;
            p = dummy;
        }
        return dummy.next;
    }
}
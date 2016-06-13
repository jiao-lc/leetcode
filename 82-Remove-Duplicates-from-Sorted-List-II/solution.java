/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        if(head == null)    return null;
        int c = head.val;
        while(head.next != null) {
            if(c != head.next.val) {
                pre = pre.next;
                head = head.next;
            } else {
                while(head.next != null && c == head.next.val) {
                    head = head.next;
                }
                pre.next = head.next;
                head = head.next;
            }
            if(head != null)
                c = head.val;
        }
        return dummy.next;
    }
}
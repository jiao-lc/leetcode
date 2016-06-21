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
        return sort(head);
    }
    
    public ListNode sort(ListNode head) {
        if(head == null || head.next == null)   return head;
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        head = sort(head);
        head2 = sort(head2);
        return merge(head, head2);
    }
    
    public ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while(h1 != null && h2 != null) {
            if(h1.val < h2.val) {
                p.next = h1;
                p = p.next;
                h1 = h1.next;
            } else {
                p.next = h2;
                p = p.next;
                h2 = h2.next;
            }
        }
        if(h1 == null) p.next = h2;
        else p.next = h1;
        return dummy.next;
    }
}
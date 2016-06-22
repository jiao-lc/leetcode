/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null)    return true;
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode h2 = slow.next;
        slow.next = null;
        ListNode p = head.next;
        head.next = null;
        while(p != null) {
            ListNode tmp = p.next;
            p.next = head;
            head = p;
            p = tmp;
        }
        if(fast == null)    head = head.next;
        while(head != null && h2 != null) {
            if(head.val != h2.val)  return false;
            head = head.next;
            h2 = h2.next;
        }
        return head == h2;
    }
}
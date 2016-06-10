/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode h1 = head;
        ListNode h2 = head.next;
        while(h1 != null && h2 != null && h2.next != null && h1 != h2) {
            h1 = h1.next;
            h2 = h2.next.next;
        }
        if(h1 == h2 && h1 != null)
            return true;
        else
            return false;
    }
}
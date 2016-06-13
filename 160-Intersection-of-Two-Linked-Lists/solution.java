/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA, pb = headB;
        if(pa == null || pb == null)    return null;
        int time = 0;
        while(pa != null && pb != null && pa.val != pb.val) {
            pa = pa.next;
            pb = pb.next;
            if(pa == null && time < 1) {
                pa = headB;
                time++;
            }
            if(pb == null) {
                pb = headA;
            }
        }
        return pa;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)   return null;
        if(lists.length == 1)   return lists[0];
        int len = lists.length;
        ListNode node = mergeLists(lists, 0, len - 1);
        return node;
    }
    
    public ListNode mergeLists(ListNode[] lists, int start, int end) {
        if(start == end)    return lists[start];
        int mid = start + (end - start) / 2;
        ListNode node1 = mergeLists(lists, start, mid);
        ListNode node2 = mergeLists(lists, mid + 1, end);
        return merge(node1, node2);
    }
    
    public ListNode merge(ListNode node1, ListNode node2) {
        if(node1 == null)  return node2;
        if(node2 == null)  return node1;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(node1 != null && node2 != null) {
            if(node1.val < node2.val) {
                head.next = node1;
                node1 = node1.next;
            } else {
                head.next = node2;
                node2 = node2.next;
            }
            head = head.next;
        }
        if(node1 != null) {
            head.next = node1;
        } else {
            head.next = node2;
        }
        return dummy.next;
    }
}
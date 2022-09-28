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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode fh = new ListNode(-1, head);
        ListNode fast = fh;
        ListNode curr = fh;
        while(n-- > 0 && fast != null){
            fast = fast.next;
        }
        while(fast.next != null){
            fast = fast.next;
            curr = curr.next;
        }
        
        if(curr != null){
            if(curr.next != null){
                curr.next = curr.next.next;
            }
        }
        return fh.next;
    }
}

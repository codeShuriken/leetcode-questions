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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null)return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode begin = dummy, end = head;
        int i = 0;
        while (end != null){
            if(++i % k == 0){
                begin = reverse(begin, end.next);
                end = begin.next;
            }else{
                end = end.next;
            }
        }
        return dummy.next;
    }
    
    private ListNode reverse(ListNode begin, ListNode end){
        ListNode prev = begin, cur = begin.next, tempCur = cur;
        while (cur != end){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        tempCur.next = end;
        begin.next = prev;
        return tempCur;
    }
}
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
    int doubleutil(ListNode head){
        if(head==null) return 0;
        int c=doubleutil(head.next);
        int nv=(head.val)*2+c;
        head.val=nv%10;
        return nv/10;
    }
    public ListNode doubleIt(ListNode head) {
        int lastc=doubleutil(head);
        if(lastc>0){
            ListNode newh=new ListNode(lastc);
            newh.next=head;
            return newh;

        }
        return head;
    }
}
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
    public ListNode reverse(ListNode head){
        if(head==null || head.next==null){
            return head;
        }

        ListNode last=reverse(head.next);
        head.next.next=head;
        head.next=null;
        return last;
    }
    public ListNode doubleIt(ListNode head) {
        head=reverse(head);
        ListNode curr=head;
        ListNode prev=null;
        int carry=0;
        while(curr!=null){
            int nv=curr.val*2+carry;
            curr.val=nv%10;
            if(nv>=10){
                carry=1;
            }else{
                carry=0;
            }

            prev=curr;
            curr=curr.next;
        }

        if(carry!=0){
            ListNode newNode=new ListNode(carry);
            prev.next=newNode;
        }
        return reverse(head);
    }
}
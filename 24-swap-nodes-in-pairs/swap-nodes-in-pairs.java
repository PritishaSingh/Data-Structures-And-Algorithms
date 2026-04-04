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
    public ListNode swapPairs(ListNode head) {
    //     if(head==null || head.next==null){
    //         return head;
    //     }
    //    ListNode slow=head;
    //    ListNode fast=head.next;
    //    while(slow!=null && fast!=null){
    //     int temp=slow.val;
    //     slow.val=fast.val;
    //     fast.val=temp;
    //      if (fast.next != null && fast.next.next != null) {
    //             slow = fast.next;
    //             fast = fast.next.next;
    //         } else {
    //             break;
    //         }
    //    } 
    //    return head;
     if(head==null || head.next==null){
        return head;
     }
     ListNode first=head;
     ListNode sec=head.next;
     ListNode prev=null;
     while(first!=null && sec !=null){
        ListNode third=sec.next;
        sec.next=first;
        first.next=third;
        if(prev!=null){
            prev.next=sec;
        }
        else{
            head=sec;
        }
        prev=first;
        first=third;
        if(third!=null){
        sec=third.next;
        }
     }
     return head;

    }
}
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
    public ListNode detectCycle(ListNode head) {
        // HashSet<ListNode> hs=new HashSet<>();
        // ListNode temp=head;
        // while(temp!=null){
        //     if(hs.contains(temp)){
        //         return temp;
        //     }
        //     hs.add(temp);
        //     temp=temp.next;
        // }
        // return null;
        if(head==null|| head.next==null) return null;
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow) break;
            
        }
        if(slow!=fast) return null;

        ListNode p=head;
        while(slow!=p){
            slow=slow.next;
            p=p.next;
        }
        return p;
    }
}
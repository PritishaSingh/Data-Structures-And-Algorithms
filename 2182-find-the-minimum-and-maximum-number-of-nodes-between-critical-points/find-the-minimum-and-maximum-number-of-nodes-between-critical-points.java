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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev=head;
        ListNode curr=head.next;
        int pcp=0;
        int fcp=0;
        int mind=Integer.MAX_VALUE;
        int i=1;
        while(curr.next!=null){
            if((curr.val<prev.val && curr.val<curr.next.val) || (curr.val>prev.val && curr.val>curr.next.val)){
                if(pcp==0){
                    pcp=i;
                    fcp=i;
                }else{
                    mind=Math.min(mind,i-pcp);
                    pcp=i;
                }
            }
            i++;
            prev=curr;
            curr=curr.next;
        }

        if(mind==Integer.MAX_VALUE){
            return  new int[]{-1,-1};
        }
        return new int[]{mind,pcp-fcp};
        
    }
}
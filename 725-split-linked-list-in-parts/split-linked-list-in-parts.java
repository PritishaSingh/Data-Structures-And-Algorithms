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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode curr=head;
        int L=0;
        while(curr!=null){
            L++;
            curr=curr.next;
        }

        int ebn=L/k;
        int exn=L%k;

        ListNode arr[]=new ListNode[k];
        Arrays.fill(arr,null);
        curr=head;
        ListNode prev=null;
        for(int i=0; i<k; i++){
            arr[i]=curr;
            for(int c=1; c<=ebn+(exn>0?1:0); c++){
                prev=curr; 
                curr=curr.next;
            }

            if(prev!=null)
            prev.next=null;
            exn--;
        }
        return arr;
    }
}
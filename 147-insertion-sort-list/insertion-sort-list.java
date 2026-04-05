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
    public ListNode insertionSortList(ListNode head) {
        ListNode temp=head;
        ArrayList<Integer> arr=new ArrayList<>();
        
        while(temp!=null){
            arr.add(temp.val);
            temp=temp.next;
        }

        for(int i=0; i<arr.size(); i++){
            for(int j=i+1; j<arr.size(); j++){
                if(arr.get(i)>arr.get(j)){
                   int t = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, t);
                }
            }
        }

            ListNode dummy = new ListNode(0);
            ListNode curr = dummy;

            for(int val : arr){
                curr.next = new ListNode(val);
                curr = curr.next;
            }
            return dummy.next;
    }
}
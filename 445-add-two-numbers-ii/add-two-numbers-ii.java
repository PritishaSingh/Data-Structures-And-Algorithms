// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
// class Solution {
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         l1=reverse(l1);
//         l2=reverse(l2);

        
//         int carry=0;
//         ListNode ans=null;
//         while(l1!=null || l2!=null || carry!=0){
//             int sum=carry;
//             if(l1!=null){
//                 sum+=l1.val;
//                 l1=l1.next;
//             }
//             if(l2!=null){
//                 sum+=l2.val;
//                 l2=l2.next;
//             }
//             int digit=sum%10;
//             carry=sum/10;            
//             ListNode newNode=new ListNode(digit);
//             newNode.next=ans;
//             ans=newNode;
//         }  

//         return ans;
//     }

//     public ListNode reverse(ListNode head){
//         if(head==null || head.next==null){
//             return head;
//         }
//         ListNode last=reverse(head.next);
//         head.next.next=head;
//         head.next=null;
//         return last;
//     }


// }
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        l1 = reverse(l1);
        l2 = reverse(l2);

        int carry = 0;
        ListNode ans = new ListNode(0);

        while (l1 != null || l2 != null) {

            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            sum = sum % 10;

            ans.val = sum;

            ListNode newNode = new ListNode(carry);
            newNode.next = ans;
            ans = newNode;
        }

        // If no carry, remove extra node
        if (ans.val == 0) {
            return ans.next;
        }

        return ans;
    }

    public ListNode reverse(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = reverse(head.next);

        head.next.next = head;
        head.next = null;

        return last;
    }
}
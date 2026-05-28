/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { 
 *         this.val = val; 
 *         this.next = next; 
 *     }
 * }
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    public TreeNode sortedListToBST(ListNode head) {
        return makeTree(head);
    }

    public TreeNode makeTree(ListNode head) {

        // base case
        if(head == null)
            return null;

        // single node
        if(head.next == null)
            return new TreeNode(head.val);

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // find middle
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // break left half
        prev.next = null;

        TreeNode root = new TreeNode(slow.val);

        root.left = makeTree(head);
        root.right = makeTree(slow.next);

        return root;
    }
}
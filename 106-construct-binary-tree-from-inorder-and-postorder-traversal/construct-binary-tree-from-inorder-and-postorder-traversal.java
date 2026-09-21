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
    static int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
          int n=postorder.length;
         idx=n-1;
        return constructTree(postorder, inorder, 0, n-1);
    }

     public static TreeNode constructTree(int[] postorder, int[] inorder, int start, int end){
        if(start>end) return null;
        int val=postorder[idx];
        int i=start;
        for(; i<inorder.length; i++){
            if(val==inorder[i]) break;
        }

        idx--;
        TreeNode root=new TreeNode(val);
        root.right= constructTree(postorder, inorder, i+1, end);
        root.left= constructTree(postorder, inorder, start, i-1);
        return root;

    }
}
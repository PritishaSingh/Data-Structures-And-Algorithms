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
    int maxs;

    public int solve(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=solve(root.left);
        int r=solve(root.right);

        int bottom=l+r+root.val;
        int any=Math.max(l,r)+root.val;
        int onlyroot=root.val;

       maxs = Math.max(maxs, Math.max(bottom, Math.max(onlyroot, any)));
        return Math.max(any, onlyroot);
    }
    public int maxPathSum(TreeNode root) {
        maxs=Integer.MIN_VALUE;
        solve(root);
        return maxs;
    }
}
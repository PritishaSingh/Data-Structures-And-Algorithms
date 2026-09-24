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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null) return true;
        q.offer(root);
        boolean f=false;
        while(!q.isEmpty()){
            TreeNode node=q.remove();
            if(node==null) f=true;
            else{
                if(f==true){
                    return false;
                }
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return true;
    }
}
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
    HashMap<Integer, Integer>hm=new HashMap<>();
    int maxD=0;

    public void Depth(TreeNode root, int level){
        if(root==null) return;
        maxD=Math.max(maxD, level);
        hm.put(root.val, level);
        Depth(root.left, level+1);
        Depth(root.right,level+1);
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Depth(root,0);
       return lca(root);

    }
     
    public TreeNode lca(TreeNode root){
        if(root==null || hm.get(root.val)==maxD) return root;
        TreeNode leftN=lca(root.left);
        TreeNode rightN=lca(root.right);
        if(leftN!=null && rightN!=null) return root;
        if(leftN!=null) return leftN;
        return rightN;
    }

}
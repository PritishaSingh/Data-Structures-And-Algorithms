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
    public boolean isValidBST(TreeNode root) {
        //  ArrayList<Integer> list=new ArrayList<>();
        //  inorder(root, list);
        //  for(int i=0; i<list.size()-1; i++){
        //     if(list.get(i)>=list.get(i+1)){
        //         return false;
        //     }
        //  }
        // return true;

        return isBst(root, null, null);
    }

    private boolean isBst(TreeNode root, TreeNode min ,TreeNode max){
        if(root==null){
            return true;
        }
        if(min!=null && root.val<=min.val) return false;
        else if(max!=null && root.val>=max.val) return false;
        
        return isBst(root.left, min, root) && isBst(root.right, root, max);
    }

    // private List inorder(TreeNode root, ArrayList<Integer> list){
    //     if(root==null){
    //         return list;
    //     }
    //     inorder(root.left, list);
    //     list.add(root.val);
    //     inorder(root.right, list);
    //     return list;

    // }
}
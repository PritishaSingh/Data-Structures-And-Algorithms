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
    public List<Integer> rightSideView(TreeNode root) {
        //Breadth First Search Code
        // List<Integer> ans=new ArrayList<>();
        // Queue<TreeNode> q=new LinkedList<>();
        // if(root==null) return ans;
        // q.add(root);
        // while(!q.isEmpty()){
        //     int size=q.size();
        //     for(int i=0; i<size; i++){
        //         TreeNode curr=q.remove();
        //         if(i==size-1) ans.add(curr.val);
        //         if(curr.left!=null) q.add(curr.left);
        //         if(curr.right!=null) q.add(curr.right);
                
        //     }

        // }
        // return ans;

        // DFS code

        List<Integer> ans=new ArrayList<>();
        int level=1;
         preorder(root, ans, level);
         return ans;
    }

    public void preorder(TreeNode root, List<Integer> ans, int level){
        if(root==null) return;
        if(level>ans.size()) ans.add(root.val);
        preorder(root.right, ans, level+1);
        preorder(root.left, ans, level+1);
    }
}
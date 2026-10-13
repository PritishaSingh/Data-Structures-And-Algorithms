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

    public int maxLevelSum(TreeNode root) {
        int maxlevel=1;
        int maxsum=Integer.MIN_VALUE;
        int level=1;
        
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            int i=0;
            int sum=0;
            while(i<size){
                TreeNode node=q.remove();
                sum+=node.val;
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
                i++;
            }
            
            if(sum>maxsum){
                maxsum=sum;
                maxlevel=level;
            }
            level+=1;
        }
        return maxlevel;
    }
}
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null)
        {
            return true;
        }  
      ArrayList a1=new ArrayList<>();
      leaf(root1,a1);
    ArrayList a2=new ArrayList<>();
       leaf(root2,a2);
       if(a1.size()!=a2.size())
       {
        return false;
       }
       for(int i=0;i<a1.size();i++)
       {
        if(!a1.get(i).equals(a2.get(i)))
        {
            return false;
        }
       } 
       return true;     
    }
    private void leaf(TreeNode root,ArrayList a){
        if(root==null)return;
        if(root.left==null && root.right==null)
        {
            a.add(root.val);
            return ;
        }
       leaf(root.left,a);
       leaf(root.right,a);
    }
 }
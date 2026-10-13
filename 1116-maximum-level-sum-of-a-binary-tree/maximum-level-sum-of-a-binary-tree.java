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
    HashMap<Integer, Integer> hm;
    void dfs(TreeNode root, int l){
        if(root==null) return;
        hm.put(l, hm.getOrDefault(l, 0) + root.val);
        dfs(root.left, l+1);
        dfs(root.right, l+1);

    }
    public int maxLevelSum(TreeNode root) {
        hm=new HashMap<>();
        dfs(root,1);
        int ms=Integer.MIN_VALUE;
        int resl=0;
        for(Map.Entry<Integer, Integer> set:hm.entrySet()){
            int l=set.getKey();
            int sum=set.getValue();
            if(ms<sum){
                ms=sum;
                resl=l;
            }
        }
        return resl;
    }
}
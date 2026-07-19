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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, targetSum, path, ans);
        return ans;
    }

    public void dfs(TreeNode node, int target, List<Integer> path, List<List<Integer>> ans){
        if(node == null) return;

        path.add(node.val);

        if(node.left == null && node.right == null && target == node.val){
            ans.add(new ArrayList<>(path));
        }

        dfs(node.left, target - node.val, path, ans);
        dfs(node.right, target - node.val, path, ans);

        path.remove(path.size() - 1); // backtrack
    }
}
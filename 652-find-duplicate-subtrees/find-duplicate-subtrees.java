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

    public String getSubTree(TreeNode root,
                             HashMap<String, Integer> hm,
                             List<TreeNode> ans) {

        if (root == null) {
            return "N";
        }

        String s = String.valueOf(root.val) + "," +
                   getSubTree(root.left, hm, ans) + "," +
                   getSubTree(root.right, hm, ans);

        hm.put(s, hm.getOrDefault(s, 0) + 1);

        // Add only when we find the duplicate for the first time
        if (hm.get(s) == 2) {
            ans.add(root);
        }

        return s;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        HashMap<String, Integer> hm = new HashMap<>();
        List<TreeNode> ans = new ArrayList<>();

        getSubTree(root, hm, ans);

        return ans;
    }
}
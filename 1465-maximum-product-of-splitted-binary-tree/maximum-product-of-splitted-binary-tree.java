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
    long sum = 0;
    long maxP = 0;

    long totalSum(TreeNode root) {
        if (root == null) return 0;

        long left = totalSum(root.left);
        long right = totalSum(root.right);

        return left + right + root.val;
    }

    long find(TreeNode root) {
        if (root == null) return 0;

        long left = find(root.left);
        long right = find(root.right);

        long subtreeSum = root.val + left + right;

        long remaining = sum - subtreeSum;

        maxP = Math.max(maxP, subtreeSum * remaining);

        return subtreeSum;
    }

    public int maxProduct(TreeNode root) {
        sum = totalSum(root);

        find(root);

        return (int)(maxP % 1_000_000_007);
    }
}
class Solution {

    int idx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return solve(preorder, inorder, 0, n - 1);
    }

    public TreeNode solve(int[] preorder, int[] inorder, int start, int end) {

        if (start > end) return null;

        int rootval = preorder[idx++];

        int i = start;

        for (; i <= end; i++) {
            if (inorder[i] == rootval) {
                break;
            }
        }

        TreeNode root = new TreeNode(rootval);

        root.left = solve(preorder, inorder, start, i - 1);

        root.right = solve(preorder, inorder, i + 1, end);

        return root;
    }
}
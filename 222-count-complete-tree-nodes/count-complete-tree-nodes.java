class Solution {

    public int getLeftHeight(TreeNode root) {
        int height = 0;

        while (root != null) {
            height++;
            root = root.left;
        }

        return height;
    }

    public int getRightHeight(TreeNode root) {
        int height = 0;

        while (root != null) {
            height++;
            root = root.right;
        }

        return height;
    }

    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int lh = getLeftHeight(root);
        int rh = getRightHeight(root);

        // Perfect binary tree
        if (lh == rh) {
            return (1 << lh) - 1;
        }

        // Not perfect, recursively count
        return countNodes(root.left)
             + countNodes(root.right)
             + 1;
    }
}
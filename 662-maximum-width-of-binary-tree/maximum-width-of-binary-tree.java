class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<Pair<TreeNode, Long>> que = new LinkedList<>();
        que.offer(new Pair<>(root, 0L));

        long maxWidth = 0;

        while (!que.isEmpty()) {
            int n = que.size();

            long f = que.peek().getValue();
            long l = f;

            // Get the last node's index at this level
            for (Pair<TreeNode, Long> p : que) {
                l = p.getValue();
            }

            maxWidth = Math.max(maxWidth, l - f + 1);

            while (n-- > 0) {
                Pair<TreeNode, Long> p = que.poll();

                TreeNode curr = p.getKey();
                long d = p.getValue();

                if (curr.left != null) {
                    que.offer(new Pair<>(curr.left, 2 * d + 1));
                }

                if (curr.right != null) {
                    que.offer(new Pair<>(curr.right, 2 * d + 2));
                }
            }
        }

        return (int) maxWidth;
    }
}
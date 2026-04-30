class Solution {
    Integer[][][] dp;

    public int maxPathScore(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        dp = new Integer[n][m][k + 1];

        int ans = solve(grid, 0, 0, 0, k);
        return ans == Integer.MIN_VALUE ? -1 : ans;
    }

    public int solve(int[][] grid, int i, int j, int count, int k) {
        if (i >= grid.length || j >= grid[0].length) 
            return Integer.MIN_VALUE;

        int newCount = count + (grid[i][j] > 0 ? 1 : 0);
        if (newCount > k) 
            return Integer.MIN_VALUE;

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }

        if (dp[i][j][newCount] != null) 
            return dp[i][j][newCount];

        int down = solve(grid, i + 1, j, newCount, k);
        int right = solve(grid, i, j + 1, newCount, k);

        int best = Math.max(down, right);

        if (best == Integer.MIN_VALUE) {
            dp[i][j][newCount] = Integer.MIN_VALUE;
        } else {
            dp[i][j][newCount] = grid[i][j] + best;
        }

        return dp[i][j][newCount];
    }
}
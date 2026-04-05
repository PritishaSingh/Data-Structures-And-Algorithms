// class Solution {
//     public int minPathSum(int[][] grid) {
//         return helper(0,0,grid);
//     }

//     public int helper(int row, int col, int[][] grid){
//         int n=grid.length;
//         int m=grid[0].length;
//         if (row >= n || col >= m) return Integer.MAX_VALUE;
//         if (row == n - 1 && col == m - 1) {
//             return grid[row][col];
//         }
//         int val=grid[row][col];
//         int right=helper(row, col+1, grid);
//         int down=helper(row+1, col, grid );
//         int s=Math.min(right, down);

//         if (s == Integer.MAX_VALUE) return s;
//         return val+s;
//     }
// }
class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Integer[][] dp = new Integer[n][m];
        return helper(0, 0, grid, dp);
    }

    public int helper(int row, int col, int[][] grid, Integer[][] dp) {
        int n = grid.length;
        int m = grid[0].length;

        if (row >= n || col >= m) return Integer.MAX_VALUE;

        if (row == n - 1 && col == m - 1) {
            return grid[row][col];
        }

        if (dp[row][col] != null) return dp[row][col];

        int right = helper(row, col + 1, grid, dp);
        int down = helper(row + 1, col, grid, dp);

        int minNext = Math.min(right, down);

        if (minNext == Integer.MAX_VALUE) {
            return dp[row][col] = minNext;
        }

        return dp[row][col] = grid[row][col] + minNext;
    }
}
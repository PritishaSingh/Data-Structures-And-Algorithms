class Solution {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        HashMap<Integer, int[][]> dirs = new HashMap<>();
        dirs.put(1, new int[][]{{0,-1},{0,1}});
        dirs.put(2, new int[][]{{-1,0},{1,0}});
        dirs.put(3, new int[][]{{0,-1},{1,0}});
        dirs.put(4, new int[][]{{0,1},{1,0}});
        dirs.put(5, new int[][]{{0,-1},{-1,0}});
        dirs.put(6, new int[][]{{0,1},{-1,0}});

        boolean[][] vis = new boolean[m][n]; // FIXED

        return dfs(grid, vis, dirs, 0, 0);
    }

    public boolean dfs(int[][] grid, boolean[][] vis,
                       HashMap<Integer,int[][]> dirs,
                       int row, int col) {

        int n = grid.length;      // rows
        int m = grid[0].length;   // cols

        if (row == n - 1 && col == m - 1) return true;

        vis[row][col] = true;

        for (int[] d : dirs.get(grid[row][col])) {
            int nr = row + d[0];
            int nc = col + d[1];

            // FIXED boundary
            if (nr < 0 || nc < 0 || nr >= n || nc >= m || vis[nr][nc]) continue;

            // reverse check
            for (int[] back : dirs.get(grid[nr][nc])) {
                if (nr + back[0] == row && nc + back[1] == col) {
                    if (dfs(grid, vis, dirs, nr, nc)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
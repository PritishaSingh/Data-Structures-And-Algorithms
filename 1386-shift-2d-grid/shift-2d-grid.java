class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int r = grid.length;
        int c = grid[0].length;
        int n = r * c;

        k = k % n;

        reverse(0, n - 1, grid);
        reverse(0, k - 1, grid);
        reverse(k, n - 1, grid);

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < c; j++) {
                row.add(grid[i][j]);
            }
            ans.add(row);
        }

        return ans;
    }

    public void reverse(int left, int right, int[][] grid) {

        int cols = grid[0].length;

        while (left < right) {

            int r1 = left / cols;
            int c1 = left % cols;

            int r2 = right / cols;
            int c2 = right % cols;

            int temp = grid[r1][c1];
            grid[r1][c1] = grid[r2][c2];
            grid[r2][c2] = temp;

            left++;
            right--;
        }
    }
}

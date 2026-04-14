class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        int n = robot.size();
        int m = factory.length;

        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);

        long[][] dp = new long[n + 1][m + 1];

        long INF = (long)1e15;

        // initialize
        for (int i = 0; i < n; i++) {
            dp[i][m] = INF; // no factories left
        }

        // dp[n][j] = 0 already

        // fill bottom-up
        for (int j = m - 1; j >= 0; j--) {
            for (int i = n; i >= 0; i--) {

                // option 1: skip factory
                long ans = dp[i][j + 1];

                // option 2: assign robots
                long cost = 0;

                for (int k = 0; k < factory[j][1]; k++) {
                    if (i + k >= n) break;

                    cost += Math.abs(robot.get(i + k) - factory[j][0]);
                    ans = Math.min(ans, cost + dp[i + k + 1][j + 1]);
                }

                dp[i][j] = ans;
            }
        }

        return dp[0][0];
    }
}
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int dp[][] = new int[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) {
                    if (dungeon[i][j] < 1) {
                        dp[i][j] = 1 - dungeon[i][j];
                        continue;
                    } else {
                        dp[i][j] = 1;
                        continue;
                    }
                }
                int minH = Integer.MAX_VALUE;
                if (j + 1 < m) {
                    minH = Math.min(minH, dp[i][j + 1] - dungeon[i][j]);
                }
                if (i + 1 < n) {
                    minH = Math.min(minH, dp[i+1][j] - dungeon[i][j]);
                }
                if (minH < 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = minH;
                }
            }
        }
        return dp[0][0];
    }
}

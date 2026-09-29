class Solution {
    // public static int solve(int[][] grid, int r, int c, int sum, int k,int dp[][][]){
    //     if(r>=grid.length || c>=grid[0].length){
    //         return 0;
    //     }
    //     sum=(sum+grid[r][c])%k;
    //     if(r==grid.length-1 && c==grid[0].length-1){
    //         if(sum%k==0){
    //             return 1;
    //         }else{
    //             return 0;
    //         }
    //     }
    //     if(dp[sum][r][c]!=-1){
    //         return dp[sum][r][c];
    //     }
    //     int r1=solve(grid,r,c+1,sum,k,dp);
    //     int r2=solve(grid,r+1,c,sum,k,dp);
    //     dp[sum][r][c]=(r1+r2)%1000000007;
    //     return dp[sum][r][c];
    // }
    public int numberOfPaths(int[][] grid, int k) {
        // int dp[][][]=new int[k][grid.length][grid[0].length];
        // for(int [][] mat:dp){
        //     for(int[] row:mat){
        //         Arrays.fill(row,-1);
        //     }
        // }
        // return solve(grid,0,0,0,k,dp);
        int dp[][][]=new int[grid.length][grid[0].length][k];
        for(int i=grid.length-1 ; i>=0; i--){
            for(int j=grid[0].length-1; j>=0; j--){
                for(int rem=0; rem<k; rem++){
                    if(i==grid.length-1 && j==grid[0].length-1){
                        int num=(rem+grid[i][j])%k;
                        if(num==0){
                            dp[i][j][rem]=1;
                        }
                        continue;
                    }
                    int num=(rem+grid[i][j])%k;
                    int way1=0;
                    int way2=0;
                    if(i+1<grid.length){
                        way1=dp[i+1][j][num];
                    }
                    if(j+1<grid[0].length){
                        way2=dp[i][j+1][num];
                    }
                    dp[i][j][rem]=(way1+way2)%1000000007;
                }
            }
        }
        return dp[0][0][0];
    }
}

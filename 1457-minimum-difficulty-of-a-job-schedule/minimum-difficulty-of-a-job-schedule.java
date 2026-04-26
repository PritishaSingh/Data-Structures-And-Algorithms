class Solution {
    public int minDifficulty(int[] jD, int d) {
       int n=jD.length;
       if(n<d ) return -1;
       int dp[][]=new int[n+1][d+1];
       for(int i=0; i<n; i++){
       Arrays.fill(dp[i],-1);
       }
       return solve(jD, n, dp, d, 0); 
    }

    public int solve(int[] jD, int n, int[][] dp, int d, int idx){
        if(d==1){
            int max=jD[idx];
            for(int i=idx; i<n; i++){
                
                    max=Math.max(max, jD[i]);
                
            }
            return dp[idx][d]=max;
        } 

        if(dp[idx][d]!=-1) return dp[idx][d];

        int maxD=jD[idx];
        int fRes=Integer.MAX_VALUE;
        for(int i=idx; i<=n-d; i++){
            maxD=Math.max(maxD, jD[i]);
            int res=maxD+solve(jD,n,dp,d-1,i+1);
            fRes=Math.min(res,fRes);
            
        }
        return dp[idx][d]=fRes;
    }
}
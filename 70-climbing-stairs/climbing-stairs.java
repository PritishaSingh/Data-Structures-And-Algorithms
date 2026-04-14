// class Solution {
//     public int climbStairs(int n) {
//         int dp[]=new int[n+1];
//         return fib(n, dp);
//     }

//     public int fib(int n, int dp[]){
//         if(n<0) return 0;
//         if(n==0 || n==1) {
//            return 1;

//         }
//         if(dp[n]!=0) return dp[n];
//         dp[n]=fib(n-1,dp)+fib(n-2,dp);

//         return dp[n];
//     }
// }

class Solution {
    //tabulation
    public int climbStairs(int n) {
        if(n<0) return 0;
        if(n==0 || n==1) return 1;
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2; i<=n; i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

   
}
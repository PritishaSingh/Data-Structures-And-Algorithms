class Solution {
    public int countCommas(int n) {
        if(n<1000) return 0;
        int ans=0;
        for(int i=1000;i<=n; i++){
            int d=String.valueOf(i).length();
            ans+=(d-1)/3;
        }
        return ans;
    }
}
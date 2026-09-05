class Solution {
    public int firstStableIndex(int[] nums, int k) {
     int n=nums.length;
        if(n==1) return 0;
        int s[]=new int[n];
        s[n-1]=nums[n-1];

        for(int i=n-2; i>=0; i--){
            s[i]=Math.min(nums[i], s[i+1]);
        }

        int pm=nums[0];
        for(int i=0; i<n; i++){
            pm=Math.max(pm,nums[i]);
            if(pm-s[i]<=k){
                return i;
            }
        }
        return -1;
    }
}
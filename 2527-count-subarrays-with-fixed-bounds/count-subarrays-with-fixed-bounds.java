class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minkpos=-1;
        int maxkpos=-1;
        int culidx=-1;
        long ans=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==minK){
                minkpos=i;
            }
            if(nums[i]==maxK){
                maxkpos=i;
            }
            if(nums[i]>maxK || nums[i]<minK){
                culidx=i;
            }
            int small=Math.min(maxkpos, minkpos);
            long temp=small-culidx;
            ans+=(temp<0)?0:temp;
        }
        return ans;
    }
}
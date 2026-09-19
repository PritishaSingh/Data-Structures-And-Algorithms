class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans=Integer.MAX_VALUE;
        int ws=0;
        int we=0;
        int sum=0;
        while(we<nums.length){
            sum+=nums[we];
            while(sum>=target){
                ans=Math.min(ans, we-ws+1);
                sum-=nums[ws];
                ws++;
            }
            
            we++;
        }
        return (ans==Integer.MAX_VALUE)?0:ans;
    }
}
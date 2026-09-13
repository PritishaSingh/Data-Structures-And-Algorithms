class Solution {
    public long findcost(int nums[], int mid, int cost[]){
        long ans=0;
        for(int i=0; i<nums.length; i++){
            ans += (long) Math.abs(nums[i] - mid) * cost[i];
        }
        return ans;
    }
    public long minCost(int[] nums, int[] cost) {
        int n=nums.length;
        long ans=Long.MAX_VALUE;
        int min=nums[0];
        int max=nums[0];
        for(int i=1; i<n; i++){
            max=Math.max(nums[i],max);
            min=Math.min(nums[i],min);
        }

        while(min<=max){
            int mid=min+(max-min)/2;
            long cost1=findcost(nums,mid,cost);
            long cost2=findcost(nums, mid+1,cost);
            ans=Math.min(ans,Math.min(cost1, cost2));
            if(cost2>cost1){
                max=mid-1;
            }else{
               min= mid+1;
            }
        }
        return ans;

    }
}
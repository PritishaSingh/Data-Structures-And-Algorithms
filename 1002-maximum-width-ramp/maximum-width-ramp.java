class Solution {
    public int maxWidthRamp(int[] nums) {
       int ans=0;
      
       int maxarr[]=new int[nums.length];
       maxarr[nums.length-1]=nums[nums.length-1];
       for(int k=nums.length-2; k>=0; k--){
            maxarr[k]=Math.max(maxarr[k+1],nums[k]);
       }
     
       for(int i=0; i<maxarr.length; i++){
        int j=i;
        if(nums[i]>maxarr[j]) continue;
        while(j<maxarr.length   && maxarr[j]>=nums[i]){
            ans=Math.max(ans,j-i);
            j++;
        }
       }
       return ans;
    }
}
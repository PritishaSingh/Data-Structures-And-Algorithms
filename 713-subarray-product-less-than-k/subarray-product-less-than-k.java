class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int we=0;
        int ws=0;
        int count=0;
        int mul=1;
        while(we<nums.length){
            mul*=nums[we];
            if(mul<k){
                count+=we-ws+1;
            }else{
                
                while(ws<we && mul>=k){
                    mul/=nums[ws];
                     ws++;
                    if(mul<k){
                        count+=we-ws+1;
                    }
                   
                }
            }
            we++;

        }
        return count;
    }
}
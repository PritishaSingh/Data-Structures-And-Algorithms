class Solution {
    public int minOperations(int[] nums, int k) {
        int totXor=0;
        for(int i=0;i<nums.length; i++){
            totXor^=nums[i];
        }

        int res=totXor^k;

        int op=0;
        while(res!=0){
            if((res&1)==1) op++;
            res>>=1;
        }
        return op;
    }
}
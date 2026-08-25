class Solution {
    public int missingMultiple(int[] nums, int k) {
        int num[]=new int[101];
        for(int i=0; i<nums.length; i++){
            num[nums[i]]=1;
        }

        int j=k;
        int i=1;
        while(j<=100){
            if(num[j]==0) break;
            j=k*i;
            i++;
        }
        return j;
    }
}
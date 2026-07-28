class Solution {
    public void swap(int s, int e, int[] nums){
        int temp=nums[s];
        nums[s]=nums[e];
        nums[e]=temp;
    }

    public void reverse(int start, int end, int[] nums){
        while(start<end){
            swap(start, end, nums);
            start++;
            end--;
        }
    }
    public void nextPermutation(int[] nums) {
        int gola_index=-1;
        for(int i=nums.length-1; i>0; i--){
            if(nums[i]>nums[i-1]){
                gola_index=i-1;
                break;
            }
        }
        int swap_index=-1;
        if(gola_index!=-1){
        for(int i=nums.length-1; i>=gola_index+1; i--){
            if(nums[i]>nums[gola_index]){
                swap_index=i;
                break;
            }
        }
        swap(gola_index, swap_index, nums);
        reverse(gola_index+1, nums.length-1,nums);
        }else{
            Arrays.sort(nums);
        }

        
    }
}
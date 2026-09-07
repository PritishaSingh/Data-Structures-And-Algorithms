class Solution {
    public int search(int[] nums, int target) {
        return bs(nums,target,nums.length-1,0);
    }

    public int bs(int []nums, int target, int high, int low){
        if(low>high) return -1;
        int mid=low+(high-low)/2;
        if(nums[mid]==target) return mid;
        else if(nums[mid]>target) return bs(nums,target,mid-1,low);
        else  return bs(nums,target,high,mid+1);
    }
}
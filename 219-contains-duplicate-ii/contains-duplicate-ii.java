class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //SLIDING WINDOW
        HashSet<Integer> hs=new HashSet<>();
        int i=0;
        int j=0;
        while(j<nums.length){
            if(Math.abs(i-j)>k){
                hs.remove(nums[i]);
                i++;
            }
            if(hs.contains(nums[j])){
                return true;
            }
            hs.add(nums[j]);
            j++;
        }
        return false;
    }
}
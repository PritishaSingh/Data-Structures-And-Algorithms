class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        int min=nums[0];
        int max=nums[0];
        HashSet<Integer> hs=new HashSet<>();
        hs.add(nums[0]);
        for(int i=1; i<nums.length; i++){
            if(nums[i]<min) min=nums[i];
            if(nums[i]>max) max=nums[i];
            hs.add(nums[i]);
        }

        for(int i=min; i<max; i++){
            if(!hs.contains(i)) ans.add(i);
        }
        return ans;
    }
}
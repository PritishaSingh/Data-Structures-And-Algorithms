class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result=new HashSet<>();
        for(int i=0; i<nums.length-2; i++){
            int l=i+1;
            int j=nums.length-1;
            while(l<j){
                int sum=nums[i]+nums[l]+nums[j];
                if(sum==0){
                    result.add(Arrays.asList(nums[i], nums[l], nums[j]));
                    l++;
                    j--;
                    
                }else if(sum<0){
                    l++;
                }else j--;
            }
        }
        return new ArrayList<>(result);
    }
}
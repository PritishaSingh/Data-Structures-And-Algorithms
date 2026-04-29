class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int ans=0;
        int i=0;
        int j=nums.size()-1;
        Collections.sort(nums);
        while(i<j){
            int sum=nums.get(i)+nums.get(j);
            if(sum<target){
                ans+=(j-i);
                i++;
            }else j--;
            
        }
        return ans;
    }
}
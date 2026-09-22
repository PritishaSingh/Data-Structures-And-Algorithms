class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, new ArrayList<>(), ans, 0,0);
        return ans;
    }

    private void helper(int nums[], int tar, List<Integer> curr, List<List<Integer>> ans, int sum, int idx){

        if(sum==tar){
            ans.add(new ArrayList<>(curr));
            return;
        } 
        if(sum>tar){
            return;
        }
       
        for(int i=idx; i<nums.length; i++){
          
            curr.add(nums[i]);
           
            
         helper(nums,tar,curr, ans, sum+nums[i], i);
         curr.remove(curr.size()-1);
        }
    }
}
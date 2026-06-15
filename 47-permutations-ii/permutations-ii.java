class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        helper(nums, new ArrayList<>(), used, ans);
        return ans;
    }

    private void helper(int[] nums,
                        List<Integer> curr,
                        boolean[] used,
                        List<List<Integer>> ans) {

        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            

            if (used[i]) continue;

            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            used[i] = true;
           
            curr.add(nums[i]);
    
            helper(nums, curr, used, ans);

            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }
}

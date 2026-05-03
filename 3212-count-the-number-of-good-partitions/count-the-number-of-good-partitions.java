class Solution {
    public int numberOfGoodPartitions(int[] nums) {
        int mod= 1_000_000_007;
        HashMap<Integer, Integer> hm=new HashMap<>();
        for(int i=0; i<nums.length; i++){
            hm.put(nums[i],i);
        }
        int i=0;
        int ans=1;
        int j=hm.get(nums[0]);
        while(i<nums.length){
            if(i>j){
                ans=(ans*2)%mod;
            }
            j=Math.max(j,hm.get(nums[i]));
            i++;
        }
        return ans;
    }
}
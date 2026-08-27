class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> s=new Stack<>();
        int n=nums.length;
        int num3=Integer.MIN_VALUE;
        for(int i=n-1; i>=0; i--){
            if(nums[i]<num3) return true;
            while(!s.isEmpty() && s.peek()<nums[i]){
                num3=s.pop();
            }
            s.push(nums[i]);
        }
        return false;
    }
}
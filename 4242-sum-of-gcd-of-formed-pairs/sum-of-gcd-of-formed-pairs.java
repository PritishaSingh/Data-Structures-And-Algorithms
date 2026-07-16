class Solution {
    public long gcdSum(int[] nums) {
        int max=nums[0];
        int [] prefix=new int[nums.length];
        for(int i=0; i<nums.length; i++){
            max=Math.max(nums[i], max);
            prefix[i]=gcd(nums[i], max);
        }

        Arrays.sort(prefix);

        int start=0;
        int end=prefix.length-1;
        long sum=0;
        while(start<end){
            sum+=gcd(prefix[start],prefix[end]);
            start++;
            end--;
        }
        return sum;

    }

    public static int gcd(int x, int y){
        return (y==0)?x:gcd(y, x%y);
    }
}
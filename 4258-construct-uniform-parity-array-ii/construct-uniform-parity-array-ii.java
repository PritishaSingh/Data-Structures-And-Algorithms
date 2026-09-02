class Solution {
    public boolean uniformArray(int[] nums1) {
        Arrays.sort(nums1);
        if(nums1[0]%2!=0) return true;
        else{
            for(int i=0; i<nums1.length; i++){
                if(nums1[i]%2!=0) return false;
            }
        }
        return true;
    }
}
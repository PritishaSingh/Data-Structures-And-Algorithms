class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int dis=0;
        int i=0,j=0;
        while(i<nums1.length && j<nums2.length){
            if(i<=j && nums1[i]<=nums2[j] ){
                dis=Math.max(dis, j-i);
                j++;
            }else{
                i++;
                j++;
            }
        }
        return dis;
    }
}
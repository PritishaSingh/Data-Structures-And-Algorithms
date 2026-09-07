class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l=0;
        int r=arr.length-1;
        while(l<=r){
            int m=l+(r-l)/2;
            int mte=arr[m]-(m+1);
            if(mte<k){
                l=m+1;
            }else{
                r=m-1;
            }
        }
        return l+k;
    }
}
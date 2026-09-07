class Solution {
    public int findKthPositive(int[] arr, int k) {
        int num=1;
        int i=0;
        int n=arr.length;
        while(i<n && k>0){
            if(num==arr[i]){
                i++;
            }else{
                k--;
            }
            num++;
        }
        while(k>0){
            num++;
            k--;
        }
        return num-1;
    }
}
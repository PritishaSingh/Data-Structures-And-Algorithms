class Solution {
    public boolean canReach(int[] arr, int start) {
        return solve(arr,start);
    }

    public boolean solve(int[] arr, int i){
        if(i<0 || i>=arr.length || arr[i]<0) return false;
        if(arr[i]==0) return true;
        arr[i]=arr[i]*-1;
        return solve(arr, i-arr[i]) || solve(arr, arr[i]+i);
    }
}
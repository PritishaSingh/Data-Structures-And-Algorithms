class Solution {
    public int largestAltitude(int[] gain) {
        int ans=0;
        int gain1=0;
        for(int i=0; i<gain.length; i++){
            gain1+=gain[i];
            ans=Math.max(ans,gain1);
        }
        return ans;
    }
}
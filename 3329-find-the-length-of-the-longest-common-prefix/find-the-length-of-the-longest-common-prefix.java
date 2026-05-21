class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> hs=new HashSet<>();
        for(int val:arr1){
            while(!hs.contains(val) && val>0){
                hs.add(val);
                val/=10;
            }
        }

        int res=0;
        for(int val:arr2){
            while(!hs.contains(val) && val>0){
                val/=10;
            }
            if(val>0){
                res=Math.max(res, (int)Math.floor(Math.log10(val)) + 1);
            }
        }
        return res;
    }
}
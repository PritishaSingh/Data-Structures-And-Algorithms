class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // HashMap<Integer, Integer> hm=new HashMap<>();
        // int ans[]=new int[2];
        // for(int i=0; i<numbers.length; i++){
        //     if(hm.containsKey(target-numbers[i])){
        //         ans[0]=hm.get(target-numbers[i]);
        //         ans[1]=i+1;
        //         return ans;
        //     }else{
        //         hm.put(numbers[i],i+1);
        //     }
        // }
        // return ans;

        //optimised
        int start=0;
        int end=numbers.length-1;
        int ans[]=new int[2];
        while(start<end){
            if((numbers[start]+numbers[end])==target){
                ans[0]=start+1;
                ans[1]=end+1;
                return ans;
            }else if((numbers[start]+numbers[end])>target){
                end--;
            }else{
                start++;
            }
        }
        return ans;
    }
}
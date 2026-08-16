class Solution {
    public int singleNumber(int[] nums) {
        int result=0;
        for(int bit=0; bit<=31; bit++){
            int cones=0;
            int czero=0;
            for(int num:nums){
                if((num&(1<<bit))==0){
                    czero++;
                }else{
                    cones++;
                }
            }
            if(cones%3!=0){
                result=(result|(1<<bit));
            }
        }
        return result;
    }
}
class Solution {
    public int minSwaps(String s) {
        int ans, open=0, close=0;
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            if(ch=='['){
                open++;
            }else if(open<=0){
                close++;
            }else{
                open--;
            }
        }
        ans=(int)(Math.ceil(open/2.0)+Math.ceil(close/2.0))/2;
        return ans;
    }
}
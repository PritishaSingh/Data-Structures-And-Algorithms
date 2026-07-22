class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int count=0;
        int maxsum=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='1') count++;
        }
        ArrayList<Integer> zeroblo=new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='0'){
                int start=i;
                while(i<s.length() && s.charAt(i)=='0' ){
                    i++;
                }
                zeroblo.add(i-start);
            }
        }
        
        for(int i=1; i<zeroblo.size(); i++){
            maxsum=Math.max(maxsum,zeroblo.get(i)+zeroblo.get(i-1));
        }
        return maxsum+count;

    }
}
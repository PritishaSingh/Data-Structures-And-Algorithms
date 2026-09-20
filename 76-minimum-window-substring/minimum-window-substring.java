class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> hm=new HashMap<>();
        int ws=0;
        int we=0;
        for(int i=0; i<t.length(); i++){
            char ch=t.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }

        int unc=hm.size();
        int si=-1;
        int minlen=Integer.MAX_VALUE;
        int n=s.length();
        while(we<n){
            char ch=s.charAt(we);
            if(hm.containsKey(ch)){
                 hm.put(ch,hm.get(ch)-1);
                 if(hm.get(ch)==0){
                    unc--;
                 } 
            }
            while(unc==0){
                int len=we-ws+1;
                if(len<minlen){
                    minlen=len;
                    si=ws;
                }
                ch=s.charAt(ws);
                 if(hm.containsKey(ch)){
                 hm.put(ch,hm.get(ch)+1);
                 if(hm.get(ch)>0){
                    unc++;
                 } 
            }
                ws++;
            }
            we++;
        }
       if(si==-1){
        return "";
       }
       return s.substring(si,si+minlen);
    }
}
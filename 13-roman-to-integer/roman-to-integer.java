class Solution {
    public int romanToInt(String s) {
        int res=0;
        HashMap<Character, Integer> hs=new HashMap<>();
        hs.put('I', 1);
        hs.put('V', 5);
        hs.put('X', 10);
        hs.put('L', 50);
        hs.put('C', 100);
        hs.put('D', 500);
        hs.put('M', 1000);
        for(int i=0; i<s.length()-1; i++){
            if(hs.get(s.charAt(i))<hs.get(s.charAt(i+1))){
                res-=hs.get(s.charAt(i));
            }else{
                res+=hs.get(s.charAt(i));
            }
        }
        return res+hs.get(s.charAt(s.length()-1));
    }
}
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans=new ArrayList<>();
        HashMap<Character, Integer> hs=new HashMap<>();
        for(int i=0; i<s.length(); i++){
            hs.put(s.charAt(i),i);
        }

        int i=0;
        int j=hs.get(s.charAt(0));
        int start=0;
        while(i<s.length()){
            if(i>j){
                ans.add(j-start+1);
                start=i;
            }
            j=Math.max(j, hs.get(s.charAt(i)));
            i++;
        }
        ans.add(j - start + 1);
        return ans;
    }

}
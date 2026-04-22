class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {

        List<String> ans=new ArrayList<>();
        for(int i=0; i<queries.length; i++){
            for(int j=0; j<dictionary.length; j++){
                if(canchange(queries[i],dictionary[j])){
                    ans.add(queries[i]);
                    break;
                }
            }
        }
        return ans;
    }

    public boolean canchange(String a, String b){
        int i=0; int j=0;
        int c=0;
        while(i<a.length() && j<b.length()){
            if(a.charAt(i)!=b.charAt(j)){
                c++;
                if(c>2) return false;
            }
            i++;
            j++;
        }
        return true;
    }
}
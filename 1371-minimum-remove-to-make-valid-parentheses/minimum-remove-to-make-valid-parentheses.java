class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st=new Stack<>();
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                st.push(i);
            }else if(s.charAt(i)==')'){
                if(st.isEmpty()){
                    hs.add(i);
                }else{
                    st.pop();
                }
            }
        }

        while(!st.isEmpty()){
            hs.add(st.pop());
        }
        String res="";
        for(int i=0; i<s.length(); i++){
            if(!hs.contains(i)){
                res+=s.charAt(i);
            }
        }
        return res;
    }
}
class Solution {
    public String removeStars(String s) {
        Stack<Character> stc=new Stack<>();
        StringBuilder st=new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            if(ch=='*' && !stc.isEmpty()){
                
                    stc.pop();
            }else{
                stc.push(ch);
            }
            
        }
        while(!stc.isEmpty()){
            st.append(stc.pop());
        }
        st.reverse();
        return st.toString();
    }
}
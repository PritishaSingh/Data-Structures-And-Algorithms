class Solution {
    public int minimumDeletions(String s) {
        Stack<Character> st=new Stack<>();
        int count=0;
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
           if(ch=='a'){
            if(!st.isEmpty() && st.peek()=='b'){
                count++;
                st.pop();
            }
           }
           else{
            st.push(ch);
           }
        }
        return count;
    }
}
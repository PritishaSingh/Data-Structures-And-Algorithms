class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack=new Stack<>();
        StringBuilder ans=new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            if(!stack.isEmpty() && stack.peek()==ch){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }

        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }
        ans.reverse();
        
        return ans.toString();
    }
}
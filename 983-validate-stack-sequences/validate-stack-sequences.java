class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s=new Stack<>();
        int m=pushed.length;
        int n=popped.length;
        int i=0, j=0;
        while(i<m && j<n){
            s.push(pushed[i]);
            while(!s.isEmpty() && j<m &&popped[j]==s.peek()){
                s.pop();
                j++;
            }
            i++;
        }
        return s.isEmpty();
    }
}
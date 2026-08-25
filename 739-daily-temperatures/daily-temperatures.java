class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int ans[]=new int[temperatures.length];
        Stack<Integer> st=new Stack<>();
        for(int i=0; i<temperatures.length; i++){
            while(!st.isEmpty() && temperatures[i]>temperatures[st.peek()]){
                int previdx=st.pop();
                ans[previdx]=i-previdx;            
            }
        st.push(i);
        }

        return ans;
    }
}
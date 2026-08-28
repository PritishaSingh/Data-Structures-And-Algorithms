class Solution {
    public String reverseParentheses(String s) {
        // Stack<Integer> st = new Stack<>();
        // StringBuilder res = new StringBuilder();

        // for (int i = 0; i < s.length(); i++) {

        //     if (s.charAt(i) == '(') {
        //         st.push(res.length());
        //     } 
        //     else if (s.charAt(i) == ')') {
        //         int j = st.pop();

        //         // Reverse characters between '(' and ')'
        //         int left = j;
        //         int right = res.length() - 1;

        //         while (left < right) {
        //             char temp = res.charAt(left);
        //             res.setCharAt(left, res.charAt(right));
        //             res.setCharAt(right, temp);

        //             left++;
        //             right--;
        //         }
        //     } 
        //     else {
        //         res.append(s.charAt(i));
        //     }
        // }

        // return res.toString();


        //APPROACH 2
        int n=s.length();
        Stack<Integer> opi=new Stack<>();
        int door[]=new int[n];
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='('){
                opi.push(i);
            }else if(s.charAt(i)==')'){
                int j=opi.pop();
                door[i]=j;
                door[j]=i;

            }
        }
        StringBuilder res=new StringBuilder();
        int flag=1;
        for(int i=0; i<n; i+=flag){
            if(s.charAt(i)=='(' || s.charAt(i)==')'){
                i=door[i];
                flag=-flag;
            }else{
                res.append(s.charAt(i));
            }
        }
    return res.toString();

    }
}
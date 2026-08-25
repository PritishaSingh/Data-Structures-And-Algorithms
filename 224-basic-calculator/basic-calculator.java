class Solution {
    public int calculate(String s) {
        Stack<Integer> st=new Stack<>();
        int n=s.length();
        int num=0;
        int res=0;
        int sign=1;
        for(int i=0; i<n; i++){
            if(Character.isDigit(s.charAt(i))){
                num=num*10+(s.charAt(i)-'0');
            }
            else if(s.charAt(i)=='+'){
                res+=(num*sign);
                num=0;
                sign=1;
            }
            else if(s.charAt(i)=='-'){
                res+=(num*sign);
                num=0;
                sign=-1;
            }
            else if(s.charAt(i)=='('){
                st.push(res);
                st.push(sign);
                res=0;
                sign=1;
            }else if(s.charAt(i)==')'){
                res+=(num*sign);
                num=0;
                int stsign=st.pop();
                int lastres=st.pop();
                res*=stsign;
                res+=lastres;
            }           
        }
        res+=(num*sign);
        return res;
    }
}
class Solution {
    public boolean parseBoolExpr(String expression) {
        int n=expression.length();
        Stack<Character> s=new Stack<>();
        for(int i=0; i<n; i++){
            char ch=expression.charAt(i);
            if(ch==')'){
                ArrayList<Character> v=new ArrayList<>();
                while(s.peek()!='('){
                    v.add(s.pop());
                }

                s.pop();
                char op=s.pop();
                s.push(solveOp(v,op));
            }else{
                s.push(ch);
            }
        }
        return (s.peek()=='t')?true:false;
    }

    public char solveOp(ArrayList<Character> v, char op){
        if(op=='!') return v.get(0)=='t'?'f':'t';

        if(op=='&'){
            for(int i=0; i<v.size(); i++){
                if(v.get(i)=='f'){
                    return 'f';
                }
            }
            return 't';
        }

        if(op=='|'){
            for(int i=0; i<v.size(); i++){
                if(v.get(i)=='t'){
                    return 't';
                }
            }
            return 'f';
        }
        return 't';
    }
}
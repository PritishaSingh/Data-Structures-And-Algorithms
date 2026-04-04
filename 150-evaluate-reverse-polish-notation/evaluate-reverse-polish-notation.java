class Solution {
    public int evalRPN(String[] tokens) {
     Stack<Integer> s=new Stack<>();
    for(String token:tokens){
        if(token.equals("+") || token.equals("*") || token.equals("-") || token.equals("/")){
            int b=s.pop();
            int a=s.pop();
            int result=0;
             switch (token) {
                    case "+": result = a + b; break;
                    case "-": result = a - b; break;
                    case "*": result = a * b; break;
                    case "/": result = a / b; break;  // Integer division
                }
                s.push(result);
        }else{
            s.push(Integer.parseInt(token));
        }
    }
    return s.pop();
    }
}
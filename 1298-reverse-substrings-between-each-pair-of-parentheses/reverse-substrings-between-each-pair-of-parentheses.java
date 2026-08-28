class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                st.push(res.length());
            } 
            else if (s.charAt(i) == ')') {
                int j = st.pop();

                // Reverse characters between '(' and ')'
                int left = j;
                int right = res.length() - 1;

                while (left < right) {
                    char temp = res.charAt(left);
                    res.setCharAt(left, res.charAt(right));
                    res.setCharAt(right, temp);

                    left++;
                    right--;
                }
            } 
            else {
                res.append(s.charAt(i));
            }
        }

        return res.toString();
    }
}
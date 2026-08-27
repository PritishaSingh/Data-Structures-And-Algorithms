class Solution {
    public String removeKdigits(String num, int k) {

        Stack<Character> st = new Stack<>();

        for (char ch : num.toCharArray()) {

            while (!st.isEmpty() && k > 0 && st.peek() > ch) {
                st.pop();
                k--;
            }

            st.push(ch);
        }

        // If k is still remaining
        while (k > 0) {
            st.pop();
            k--;
        }

        // Build answer
        StringBuilder ans = new StringBuilder();

        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        ans.reverse();

        // Remove leading zeros
        int i = 0;
        while (i < ans.length() && ans.charAt(i) == '0') {
            i++;
        }

        ans = new StringBuilder(ans.substring(i));

        return ans.length() == 0 ? "0" : ans.toString();
    }
}
class Solution {
    public int maximumGain(String s, int x, int y) {

        int ans = 0;

        // Always remove the higher-value pair first
        if (x >= y) {
            ans += removePair(s, 'a', 'b', x);
            
            // Need the remaining string after removing "ab"
            s = getRemaining(s, 'a', 'b');

            ans += removePair(s, 'b', 'a', y);
        } 
        else {
            ans += removePair(s, 'b', 'a', y);

            s = getRemaining(s, 'b', 'a');

            ans += removePair(s, 'a', 'b', x);
        }

        return ans;
    }

    private int removePair(String s, char first, char second, int score) {

        Stack<Character> st = new Stack<>();
        int ans = 0;

        for (char ch : s.toCharArray()) {

            if (!st.isEmpty() && st.peek() == first && ch == second) {
                st.pop();
                ans += score;
            } 
            else {
                st.push(ch);
            }
        }

        return ans;
    }

    private String getRemaining(String s, char first, char second) {

        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (!st.isEmpty() && st.peek() == first && ch == second) {
                st.pop();
            } 
            else {
                st.push(ch);
            }
        }

        StringBuilder res = new StringBuilder();

        for (char ch : st) {
            res.append(ch);
        }

        return res.toString();
    }
}
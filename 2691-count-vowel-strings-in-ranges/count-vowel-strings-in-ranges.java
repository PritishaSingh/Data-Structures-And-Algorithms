class Solution {

    public boolean vowels(String s) {
        return isvowel(s.charAt(0)) &&
               isvowel(s.charAt(s.length() - 1));
    }

    public boolean isvowel(char a) {
        return a == 'a' || a == 'e' || a == 'i' ||
               a == 'o' || a == 'u';
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;

        int[] vowl = new int[n];
        int cv = 0;

        // Prefix sum
        for (int i = 0; i < n; i++) {
            if (vowels(words[i])) {
                cv++;
            }

            vowl[i] = cv;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            if (l == 0) {
                ans[i] = vowl[r];
            } else {
                ans[i] = vowl[r] - vowl[l - 1];
            }
        }

        return ans;
    }
}
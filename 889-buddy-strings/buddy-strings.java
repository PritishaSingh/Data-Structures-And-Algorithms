class Solution {

    public boolean checkFreq(String s) {
        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            arr[ch - 'a']++;

            if (arr[ch - 'a'] > 1) {
                return true;
            }
        }

        return false;
    }

    public boolean buddyStrings(String s, String goal) {

        if (s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {
            // If any character occurs more than once,
            // we can swap two same characters
            return checkFreq(s);
        }

        ArrayList<Integer> indices = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                indices.add(i);
            }
        }

        if (indices.size() != 2) {
            return false;
        }

        int first = indices.get(0);
        int second = indices.get(1);

        // Swap characters
        char[] chars = s.toCharArray();

        char temp = chars[first];
        chars[first] = chars[second];
        chars[second] = temp;

        return new String(chars).equals(goal);
    }
}
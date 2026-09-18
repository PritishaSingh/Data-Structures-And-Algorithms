class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        HashMap<Character, Integer> hm = new HashMap<>();

        // Frequency of characters in pattern
        for (int i = 0; i < p.length(); i++) {
            hm.put(p.charAt(i),
                    hm.getOrDefault(p.charAt(i), 0) + 1);
        }

        int i = 0;
        int j = 0;
        int k = p.length();

        List<Integer> ans = new ArrayList<>();

        while (j < s.length()) {

            // Add s[j] to the window
            if (hm.containsKey(s.charAt(j))) {
                hm.put(s.charAt(j),
                        hm.get(s.charAt(j)) - 1);
            }

            // Window size < k
            if (j - i + 1 < k) {
                j++;
            }

            // Window size == k
            else if (j - i + 1 == k) {

                // Anagram found
                if (allZero(hm)) {
                    ans.add(i);
                }

                // Remove s[i] from the window
                if (hm.containsKey(s.charAt(i))) {
                    hm.put(s.charAt(i),
                            hm.get(s.charAt(i)) + 1);
                }

                i++;
                j++;
            }
        }

        return ans;
    }

    boolean allZero(HashMap<Character, Integer> hm) {
        for (int value : hm.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}
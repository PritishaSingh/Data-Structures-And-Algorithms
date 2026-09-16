class Solution {
    public boolean wordPattern(String pattern, String s) {
  
        HashMap<Character, String> hm = new HashMap<>();
        HashMap<String, Character> mh = new HashMap<>();
        String[] words = s.split(" ");
          if (pattern.length() != words.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            char c1 = pattern.charAt(i);
            String c2 = words[i];

            if (hm.containsKey(c1)) {
                if (!hm.get(c1).equals(c2) ) return false;
            } else {
                hm.put(c1, c2);
            }

            if (mh.containsKey(c2)) {
                if (mh.get(c2) != c1) return false;
            } else {
                mh.put(c2, c1);
            }
        }

        return true;
    }
}
 

class Solution {

    HashSet<String> hs;

    public boolean isConcat(String word, HashSet<String> hs,
                            HashMap<String, Boolean> memo) {

        if (memo.containsKey(word)) {
            return memo.get(word);
        }

        for (int i = 1; i < word.length(); i++) {

            String pre = word.substring(0, i);
            String suff = word.substring(i);

            if (hs.contains(pre) &&
                (hs.contains(suff) || isConcat(suff, hs, memo))) {

                memo.put(word, true);
                return true;
            }
        }

        memo.put(word, false);
        return false;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        hs = new HashSet<>();

        for (String word : words) {
            hs.add(word);
        }

        List<String> ans = new ArrayList<>();

        for (String word : words) {

            hs.remove(word);

            HashMap<String, Boolean> memo = new HashMap<>();

            if (isConcat(word, hs, memo)) {
                ans.add(word);
            }

            hs.add(word);
        }

        return ans;
    }
}
class Solution {
    public boolean detectCapitalUse(String word) {
        int ccap = 0;

        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                ccap++;
            }
        }

        if (ccap == 0 || 
            ccap == word.length() || 
            (ccap == 1 && Character.isUpperCase(word.charAt(0)))) {
            return true;
        }

        return false;
    }
}
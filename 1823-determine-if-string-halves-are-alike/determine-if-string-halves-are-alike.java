class Solution {
    boolean isVowel(char ch) {
    ch = Character.toLowerCase(ch);
    return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
}
    public boolean halvesAreAlike(String s) {
        int n=s.length();
        int i=0; int countl=0, countr=0, j=n/2;
        while(i<n/2 && j<n){
            if(isVowel(s.charAt(i))) countl++;
            if(isVowel(s.charAt(j))) countr++;
            i++;j++;
        }
        return countl==countr;
    }
}
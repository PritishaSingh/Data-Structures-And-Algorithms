class Solution {

    public boolean allSmall(String word){
        for(int i=0; i<word.length(); i++){
            if((word.charAt(i)<'a') || (word.charAt(i)>'z')) return false;

        }
        return true;
    }

    public boolean allCapitals(String word){
        for(int i=0; i<word.length(); i++){
            if((word.charAt(i)<'A') || (word.charAt(i)>'Z')) return false;

        }
        return true;
    }

    public boolean detectCapitalUse(String word) {
       if(allCapitals(word) || allSmall(word) || allSmall(word.substring(1))){
        return true;
       } 
       return false;
    }
}
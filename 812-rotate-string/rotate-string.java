class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() !=goal.length()) return false;
        String newStringD=s+s;
        return newStringD.contains(goal);
    }
}
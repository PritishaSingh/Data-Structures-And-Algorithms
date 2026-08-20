class Solution {
    public int compress(char[] chars) {
        int i=0;
        int idx=0;
        while(i<chars.length){
            char curr_char=chars[i];
            int curr_count=0;
            while(i<chars.length && curr_char==chars[i]){
                curr_count++;
                i++;
            }
            chars[idx]=curr_char;
            idx++;
            if(curr_count>1){
            String currcount=Integer.toString(curr_count);
            int j=0;
            while(j<currcount.length()){
                chars[idx]=currcount.charAt(j);
                idx++;
                j++;
            }

            }
            
        }
        return idx;
    }
}
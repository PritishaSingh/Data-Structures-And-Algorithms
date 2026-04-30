class Solution {
    public String sortVowels(String s) {
        String vow="AEIOUaeiou";
        ArrayList<Character> arr=new ArrayList<>();
        char[] str=s.toCharArray();
        for(int i=0; i<str.length; i++){
        if(vow.indexOf(str[i])==-1){
           continue;
        }else{
             arr.add(str[i]);
        }
        }
        Collections.sort(arr);
        int j=0;
        for(int i=0;i<str.length; i++){
            if(vow.indexOf(str[i])==-1){
               continue;
            }else{
                 str[i]=arr.get(j);
                j++;
            }
        }
        return new String(str);
    }
}
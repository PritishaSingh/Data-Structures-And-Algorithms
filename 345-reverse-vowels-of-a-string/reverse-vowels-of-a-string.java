class Solution {
    public String reverseVowels(String s) {
       char arr[]=s.toCharArray();
       int start=0;
       int end=s.length()-1;
       String v="aeiouAEIOU";
       while(start<end){
        while(start<end && v.indexOf(arr[start])==-1){
            start++;
        }
        while(end>start && v.indexOf(arr[end])==-1){
            end--;
        }
        char temp=arr[start];
        arr[start]=arr[end];
        arr[end]=temp;

        start++;
        end--;
       }

       return new String(arr);
    }
}
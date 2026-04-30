class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

       
        reverse(arr, 0, n - 1);

        int i = 0;
        int l = 0, r = 0;

        while (i < n) {

           
            while (i < n && arr[i] != ' ') {
                arr[r++] = arr[i++];
            }

           
            if (l < r) {
                reverse(arr, l, r - 1);

                
                if (r < n) {
                    arr[r++] = ' ';
                }
                l = r;
            }

            i++; 
        }

        
        if (r > 0 && arr[r - 1] == ' ') {
            r--;
        }

        return new String(arr, 0,r);
    }

    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
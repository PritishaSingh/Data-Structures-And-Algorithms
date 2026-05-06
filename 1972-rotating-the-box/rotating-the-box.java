class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;

       
        char[][] rotated = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][i] = box[i][j];
            }
        }

       
        for (int i = 0; i < n; i++) {
            reverse(rotated[i]);
        }

     
        for (int col = 0; col < m; col++) {
            int empty = n - 1; 

            for (int row = n - 1; row >= 0; row--) {
                if (rotated[row][col] == '*') {
                    empty = row - 1;
                } 
                else if (rotated[row][col] == '#') {
                    rotated[row][col] = '.';
                    rotated[empty][col] = '#';
                    empty--;
                }
            }
        }

        return rotated;
    }

    private void reverse(char[] row) {
        int left = 0, right = row.length - 1;
        while (left < right) {
            char temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }
}
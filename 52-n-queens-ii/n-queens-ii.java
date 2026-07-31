class Solution {
    
    public int totalNQueens(int n) {
      
        char[][] board = new char[n][n];

        // Fill board with '.'
        for(int i = 0; i < n; i++){
            Arrays.fill(board[i], '.');
        }

        
        return solve(board, 0);
    }

    public int solve(char[][] board, int row){

        if(row == board.length){
           
            return 1;
        }

        int count=0;

        for(int col = 0; col < board.length; col++){
            
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';

                count+=solve(board, row + 1);

                // Backtrack
                board[row][col] = '.';
            }
        }
        return count;
       
    }

    public boolean isSafe(char[][] board, int row, int col){

        // vertical up
        for(int i = row - 1; i >= 0; i--){
            if(board[i][col] == 'Q') return false;
        }

        // left diagonal
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 'Q') return false;
        }

        // right diagonal
        for(int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++){
            if(board[i][j] == 'Q') return false;
        }

        return true;
    }

   
}

 
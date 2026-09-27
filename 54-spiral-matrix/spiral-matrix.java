class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result=new ArrayList<>();
        int row=matrix.length;
        int column=matrix[0].length;
        int sr=0;
        int er=row-1;
        int sc=0;
        int ec=column-1;
        while(sc<=ec && sr<=er){
            for(int j=sc; j<=ec; j++){
                result.add(matrix[sr][j]);
            }
            sr++;
            for(int i=sr; i<=er; i++){
                result.add(matrix[i][ec]);
            }
           ec--;
           if(sr<=er){
            for(int j=ec; j>=sc; j--){
                result.add(matrix[er][j]);
            }
            er--;
           }
           if(sc<=ec){
            for(int i=er; i>=sr; i--){
                result.add(matrix[i][sc]);
            }
            sc++;
           }
            
        }
    return result;
    }
}
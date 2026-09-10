class Solution {
    public double separateSquares(int[][] squares) {
       double low=Integer.MAX_VALUE;
       double high=Integer.MIN_VALUE;
       double total=0.0000;

       for(int[] square:squares){
        double x=square[0];
        double y=square[1];
        double l=square[2]; 

        total+=l*l;
        low=Math.min(low,y);
        high=Math.max(high,y+l);
       } 

       double res=0.0000;
       while(high-low>1e-5){
        double mid_y=low+(high-low)/2;
        res=mid_y;
        if(check(squares,mid_y, total)==true){
            high=mid_y;
        }else{
            low=mid_y;
        }
       }
       return res;
    }

    public boolean check(int [][] squares, double mid_y, double total){
     double botarea=0;
     for(int[] square:squares ){
        double y=square[1];
        double l=square[2]; 

        double boty=y;
        double topy=y+l;
        if(mid_y>=topy){
            botarea+=l*l;
        }else if(mid_y>boty){
            botarea+=l*(mid_y-boty);
        }
     }   
     return botarea>=total/2.0;
    }
}
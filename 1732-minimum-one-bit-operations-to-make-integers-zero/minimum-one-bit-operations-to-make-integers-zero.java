class Solution {
    public int minimumOneBitOperations(int n) {
        if(n==0) return 0;
        long F[]=new long[31];
        F[0]=1;
        for(int i=1; i<=30; i++){
            F[i]=2*F[i-1]+1;
        }

        int res=0;
        int sign=1;

        for(int i=30; i>=0; i--){
            int ithbit=((1<<i)&n);

            if(ithbit==0){
                continue;

            }
            if(sign>0){
                res+=F[i];
            }else{
                res-=F[i];
            }

            sign=sign*(-1);
        }
        return res;
    }
}
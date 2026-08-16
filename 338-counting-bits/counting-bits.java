class Solution {
    public int count(int n)
    {
        int ans=0;
        while(n!=0){
            if((n&1)==1) ans++;
            n>>=1;
        }
        return ans;
    }
    public int[] countBits(int n) {
        int countarray[]=new int[n+1];
        for(int i=0; i<n+1; i++){
            countarray[i]=count(i);
        }
        return countarray;
    }
}
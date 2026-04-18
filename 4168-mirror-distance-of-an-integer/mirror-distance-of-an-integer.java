class Solution {
    public int mirrorDistance(int n) {
       int m=getreverse(n);
       return Math.abs(n-m); 
    }

    public int getreverse(int num){
        int ans=0;
        while(num>0){
            int digit=num%10;
            ans=(ans*10)+digit;
            num/=10;
        }
        return ans;
    }
}
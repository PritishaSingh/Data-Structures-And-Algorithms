class Solution {
    public int rotatedDigits(int n) {
        int i=2;
        int ans=0;
        while(i<=n){
            if(isMirror(i)){
                ans++;
            }
            i++;
        }
        return ans;
    }

    public boolean isMirror(int num){
        boolean dif=false;
        while(num>0){
            int rem=num%10;
            if(rem==3 || rem==4 || rem==7){
                return false;
            }else if(rem==6 ||rem==9|| rem==2 || rem==5){
                dif=true;
            }
            num=num/10;
        }
        return dif;
    }
}
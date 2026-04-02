class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int [][] mat=new int[26][26];
        for(int i=0; i<26; i++){
        Arrays.fill(mat[i], Integer.MAX_VALUE);
        mat[i][i]=0;
        }
        for(int i=0; i<original.length; i++){
           int start=original[i]-'a';
           int end=changed[i]-'a';
           mat[start][end]=Math.min(mat[start][end], cost[i]);
        }

        for(int k=0; k<26; k++){
            for(int i=0; i<26; i++){
               if(mat[i][k]<Integer.MAX_VALUE){
                 for(int j=0; j<26; j++){
                  if(mat[k][j]<Integer.MAX_VALUE){
                      mat[i][j]=Math.min(mat[i][j], mat[i][k]+mat[k][j]);
                  }
                 }
               }
            }

        }
     long ans=0;
    for(int i=0; i<source.length(); i++){
        int start=source.charAt(i)-'a';
        int end=target.charAt(i)-'a';
        if(mat[start][end]==Integer.MAX_VALUE){
            return -1;
        }else{
            ans+=(long)mat[start][end];
        }
    }
    return ans;
    }
}
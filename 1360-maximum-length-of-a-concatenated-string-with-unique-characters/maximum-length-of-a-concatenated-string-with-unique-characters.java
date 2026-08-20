class Solution {
    public int maxLength(List<String> arr) {
        ArrayList<Integer> uqs=new ArrayList<>();
        for(String s:arr){
            Set<Character> set=new HashSet<>();
            for(char ch:s.toCharArray()){
                set.add(ch);
            }

            if(set.size()!=s.length()) continue;

            int val=0;
            for(char ch:s.toCharArray()){
                val|=1<<(ch-'a');
            }

            uqs.add(val);
        }
        int res[]={0};
        dfs(0,0, res, uqs);
        return res[0];
    }

    private void dfs(int idx, int temp, int[] res, List<Integer> uqs){
        res[0]=Math.max(res[0], Integer.bitCount(temp));

        for(int i=idx; i<uqs.size(); i++){
            if((temp&uqs.get(i))==0){
                dfs(i+1, temp|uqs.get(i), res, uqs);
            }
        }
    }
}
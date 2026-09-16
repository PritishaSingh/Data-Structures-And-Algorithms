class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        
        HashMap<Integer, Integer> hm = new HashMap<>();

        // Count losses of every player
        for (int i = 0; i < matches.length; i++) {
            int winner = matches[i][0];
            int loser = matches[i][1];

            
            hm.put(winner, hm.getOrDefault(winner, 0));

            
            hm.put(loser, hm.getOrDefault(loser, 0) + 1);
        }

        List<Integer> zeroLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();

        
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (entry.getValue() == 0) {
                zeroLoss.add(entry.getKey());
            } 
            else if (entry.getValue() == 1) {
                oneLoss.add(entry.getKey());
            }
        }

        
        Collections.sort(zeroLoss);
        Collections.sort(oneLoss);

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(zeroLoss);
        ans.add(oneLoss);

        return ans;
    }
}
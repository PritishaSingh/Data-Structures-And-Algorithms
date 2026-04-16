// class Solution {
//     public List<Integer> solveQueries(int[] nums, int[] queries) {
//         List<Integer> list = new ArrayList<>();

//         for(int i = 0; i < queries.length; i++){
//             int idx = queries[i];
//             int val = nums[idx];
//             int ans = Integer.MAX_VALUE;

//             for(int j = 0; j < nums.length; j++){
//                 if(j != idx && nums[j] == val){
//                     int diff = Math.abs(idx - j);
//                     int dist = Math.min(diff, nums.length - diff);
//                     ans = Math.min(ans, dist);
//                 }
//             }

//             if(ans == Integer.MAX_VALUE) list.add(-1);
//             else list.add(ans);
//         }

//         return list;
//     }
// }

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        // Step 1: map value -> list of indices
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        // Step 2: precompute answers
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for(List<Integer> list : map.values()){
            int size = list.size();

            // if only one occurrence → already -1
            if(size == 1) continue;

            for(int i = 0; i < size; i++){
                int curr = list.get(i);

                // previous index (circular)
                int prev = list.get((i - 1 + size) % size);

                // next index (circular)
                int next = list.get((i + 1) % size);

                int diff1 = Math.abs(curr - prev);
                int dist1 = Math.min(diff1, n - diff1);

                int diff2 = Math.abs(curr - next);
                int dist2 = Math.min(diff2, n - diff2);

                ans[curr] = Math.min(dist1, dist2);
            }
        }

        // Step 3: answer queries
        List<Integer> res = new ArrayList<>();
        for(int q : queries){
            res.add(ans[q]);
        }

        return res;
    }
}
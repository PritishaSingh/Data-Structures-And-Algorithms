import java.util.*;

class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] res = new long[n];

        // Step 1: Group indices by value
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        // Step 2: Process each group
        for (List<Integer> indices : map.values()) {
            int size = indices.size();

            // Prefix sum array
            long[] prefix = new long[size + 1];
            for (int i = 0; i < size; i++) {
                prefix[i + 1] = prefix[i] + indices.get(i);
            }

            // Calculate result for each index
            for (int i = 0; i < size; i++) {
                long currentIndex = indices.get(i);

                // Left contribution
                long left = currentIndex * i - prefix[i];

                // Right contribution
                long right = (prefix[size] - prefix[i + 1]) 
                             - currentIndex * (size - i - 1);

                res[indices.get(i)] = left + right;
            }
        }

        return res;
    }
}
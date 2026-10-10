class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int[] freq = new int[100001];
        int maxdiff = 0;
        long totaldiff = 0;

        for (int i = 0; i < nums1.length; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            freq[diff]++;
            maxdiff = Math.max(maxdiff, diff);
            totaldiff += diff;
        }

        int k = k1 + k2;

        if (totaldiff <= k) return 0;

        for (int i = maxdiff; i > 0 && k > 0; i--) {
            int moves = Math.min(k, freq[i]);

            freq[i] -= moves;
            freq[i - 1] += moves;
            k -= moves;
        }

        long ans = 0;

        for (int i = 0; i <= maxdiff; i++) {
            ans += (long) i * i * freq[i];
        }

        return ans;
    }
}
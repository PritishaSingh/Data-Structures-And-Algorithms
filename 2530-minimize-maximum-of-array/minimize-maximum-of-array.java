class Solution {

    public boolean isValid(int[] nums, int m, int n) {

        ArrayList<Long> arr = Arrays.stream(nums)
                .mapToLong(x -> x)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        // Move excess from right to left
        for (int i = n - 1; i > 0; i--) {

            if (arr.get(i) > m) {

                long extra = arr.get(i) - m;

                arr.set(i, (long) m);
                arr.set(i - 1, arr.get(i - 1) + extra);
            }
        }

        return arr.get(0) <= m;
    }

    public int minimizeArrayValue(int[] nums) {

        int n = nums.length;

        int maxL = 0;
        int maxR = 0;

        for (int num : nums) {
            maxR = Math.max(maxR, num);
        }

        int res = maxR;

        while (maxL <= maxR) {

            int m = maxL + (maxR - maxL) / 2;

            if (isValid(nums, m, n)) {
                res = m;
                maxR = m - 1;
            } else {
                maxL = m + 1;
            }
        }

        return res;
    }
}
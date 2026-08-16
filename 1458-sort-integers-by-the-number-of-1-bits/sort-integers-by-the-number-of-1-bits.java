class Solution {

    int findonebit(int n) {
        int ans = 0;

        while (n != 0) {
            ans += (n & 1);
            n >>= 1;
        }

        return ans;
    }

    public int[] sortByBits(int[] arr) {

        Integer[] nums = new Integer[arr.length];

        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }

        Arrays.sort(nums, (a, b) -> {
            int ca = findonebit(a);
            int cb = findonebit(b);

            if (ca == cb)
                return a - b;

            return ca - cb;
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i];
        }

        return arr;
    }
}
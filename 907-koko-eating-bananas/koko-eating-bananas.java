class Solution {

    public boolean possible(int[] piles, int m, int h) {

        long hours = 0;

        for (int num : piles) {
            hours += ((long) num + m - 1) / m;

            if (hours > h) {
                return false;
            }
        }

        return true;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();

        while (l <= r) {

            int m = l + (r - l) / 2;

            if (possible(piles, m, h)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l;
    }
}
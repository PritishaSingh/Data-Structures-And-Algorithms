class Solution {

    public boolean possible(int[] time, long givenTime, int totalTrips) {
        long actualTrips = 0;

        for (int num : time) {
            actualTrips += givenTime / num;
        }

        return actualTrips >= totalTrips;
    }

    public long minimumTime(int[] time, int totalTrips) {

        long minTime = Arrays.stream(time).min().getAsInt();

        long l = 1;
        long r = minTime * (long) totalTrips;

        while (l < r) {
            long m = l + (r - l) / 2;

            if (possible(time, m, totalTrips)) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }
}
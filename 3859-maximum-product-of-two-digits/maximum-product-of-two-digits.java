class Solution {
    public int maxProduct(int n) {
        ArrayList<Integer> digit = new ArrayList<>();

        while (n > 0) {
            int d = n % 10;
            digit.add(d);
            n = n / 10;
        }

        Collections.sort(digit);

        int size = digit.size();

        return digit.get(size - 1) * digit.get(size - 2);
    }
}
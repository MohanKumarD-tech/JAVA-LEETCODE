class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long left = 1;
        long right = 2_000_000_000; // As per constraint
        long ab = lcm(a, b);
        long bc = lcm(b, c);
        long ac = lcm(a, c);
        long abc = lcm(a, bc);

        while (left < right) {
            long mid = left + (right - left) / 2;
            long count = countUgly(mid, a, b, c, ab, ac, bc, abc);

            if (count < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return (int) left;
    }

    private long countUgly(long x, int a, int b, int c, long ab, long ac, long bc, long abc) {
        return x / a + x / b + x / c
             - x / ab - x / bc - x / ac
             + x / abc;
    }

    private long lcm(long x, long y) {
        return x / gcd(x, y) * y;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
class Solution {
    // Helper function to compute the greatest common divisor (GCD)
    public long gcd(long x, long y) {
        while (y != 0) {
            long temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
    
    // Helper function to compute the least common multiple (LCM)
    public long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    public int nthMagicalNumber(int n, int a, int b) {
        // Modulo value
        final int MOD = 1000000007;

        // Get the lcm of a and b
        long lcm_ab = lcm(a, b);

        // Binary search bounds
        long low = 1, high = (long) n * Math.min(a, b); // Starting high as a large estimate
        
        while (low < high) {
            long mid = low + (high - low) / 2;
            
            // Count how many magical numbers are <= mid
            long count = mid / a + mid / b - mid / lcm_ab;
            
            if (count >= n) {
                high = mid; // We need to find a smaller value
            } else {
                low = mid + 1; // Increase the lower bound
            }
        }
        
        // The nth magical number, modulo MOD
        return (int) (low % MOD);
    }
}
import java.math.BigInteger;

class Solution {
    // Function to calculate the GCD of a and b
    public int gcd(int a, int b) {
        return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue();
    }

    // Function to count the number of common factors
    public int commonFactors(int a, int b) {
        int gcdValue = gcd(a, b);  // Calculate GCD of a and b
        int count = 0;

        // Count divisors of the GCD
        for (int i = 1; i <= Math.sqrt(gcdValue); i++) {
            if (gcdValue % i == 0) {
                count++; // i is a divisor
                if (i != gcdValue / i) {
                    count++; // gcdValue / i is also a divisor
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        
        // Test the function with example cases
        System.out.println(obj.commonFactors(12, 6)); // Output: 4
        System.out.println(obj.commonFactors(25, 30)); // Output: 2
    }
}
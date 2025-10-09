class Solution {
    public int countPrimes(int n) {
      if (n <= 2) {
            return 0;  // No primes less than 2
        }
        
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;  // Initially assume all numbers are prime
        }
        
        // Sieve of Eratosthenes
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;  // Mark multiples of i as non-prime
                }
            }
        }
        
        // Count primes
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        
        // Test the function with example cases
        System.out.println(obj.countPrimes(10));  // Output: 4
        System.out.println(obj.countPrimes(0));   // Output: 0
        System.out.println(obj.countPrimes(1));   // Output: 0
    }
}
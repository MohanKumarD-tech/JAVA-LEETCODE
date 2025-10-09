class Solution {
    public int smallestEvenMultiple(int n) {
        if (n % 2 == 0) {
            return n; // If n is even, return n
        } else {
            return 2 * n; // If n is odd, return 2 * n
        }
    }

    public static void main(String[] args) {
        // Test the function with example cases
        Solution solution = new Solution();

        System.out.println(solution.smallestEvenMultiple(5)); // Output: 10
        System.out.println(solution.smallestEvenMultiple(6)); // Output: 6
    }
}
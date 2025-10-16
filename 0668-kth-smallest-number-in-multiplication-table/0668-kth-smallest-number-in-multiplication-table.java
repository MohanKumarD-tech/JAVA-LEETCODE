class Solution {
    public int findKthNumber(int m, int n, int k) {
        int low = 1, high = m * n;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countLessEqual(mid, m, n);
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    
    // Helper function to count how many numbers are <= x in the m x n multiplication table
    private int countLessEqual(int x, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(x / i, n); // count numbers in the i-th row less than or equal to x
        }
        return count;
    }
}
class Solution {
    public int addDigits(int num) {
        // If num is 0, return 0
        if (num == 0) {
            return 0;
        }
        // If num is not 0, use the digital root formula
        return 1 + (num - 1) % 9;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        
        // Test the function with example cases
        System.out.println(obj.addDigits(38)); // Output: 2
        System.out.println(obj.addDigits(0));  // Output: 0
    }
}
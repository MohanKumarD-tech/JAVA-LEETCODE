class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        String longest = "";

        for (int i = 0; i < s.length(); i++) {
            // Odd length palindrome
            String odd = expandAroundCenter(s, i, i);
            if (odd.length() > longest.length()) {
                longest = odd;
            }

            // Even length palindrome
            String even = expandAroundCenter(s, i, i + 1);
            if (even.length() > longest.length()) {
                longest = even;
            }
        }

        return longest;
    }
    
    private String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right); // substring from left+1 to right-1
    }
}
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        char[] s1Sort = s1.toCharArray();
        Arrays.sort(s1Sort);

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            String subStr = s2.substring(i, i + s1.length());
            char[] subArr = subStr.toCharArray();
            Arrays.sort(subArr);

            if (Arrays.equals(s1Sort, subArr)) {
                return true;
            }
        }

        return false;
    }
}
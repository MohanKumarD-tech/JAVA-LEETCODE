class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>(); 
        int n = nums.length, start = 0;
        if (n == 0) return ans; 
       
        for (int i = 1; i <= n; i++) {
            if (i == n || nums[i] != nums[i - 1] + 1) {
                ans.add(i - 1 == start ? String.valueOf(nums[start]) : nums[start] + "->" + nums[i - 1]);
                start = i;
            }
        }
        return ans;
    }
}
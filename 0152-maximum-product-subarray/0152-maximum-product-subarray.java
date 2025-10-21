class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int ele = nums[i];
            
            if (ele < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(ele, max * ele);
            min = Math.min(ele, min * ele);

            ans = Math.max(ans, max);
        }

        return ans;
    }
}
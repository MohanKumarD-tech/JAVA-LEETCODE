class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid; // min is in left part
            } else if (nums[mid] > nums[right]) {
                left = mid + 1; // min is in right part
            } else {
                // nums[mid] == nums[right], can't decide, shrink right
                right--;
            }
        }
        return nums[left]; // or nums[right], they are equal here
    }
}
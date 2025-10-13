class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            }

            // If duplicates are at boundaries, skip them
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            }
            // Left side is sorted
            else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Search left
                } else {
                    left = mid + 1; // Search right
                }
            }
            // Right side is sorted
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // Search right
                } else {
                    right = mid - 1; // Search left
                }
            }
        }

        return false; // Target not found
    }
}
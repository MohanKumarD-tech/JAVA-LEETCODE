class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Right half is unsorted, so min must be there
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            // Left half is unsorted or mid could be the smallest
            else {
                right = mid;
            }
        }

        return nums[left]; // or nums[right]; both are same now
    }
}
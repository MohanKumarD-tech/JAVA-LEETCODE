class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int right = nums[n - 1] - nums[0];

        while (left < right) {
            int mid = (left + right) / 2;
            int count = countPairs(nums, mid);

            if (count < k) {
                left = mid + 1; // Too few pairs, need more distance
            } else {
                right = mid;    // Enough pairs, try smaller distance
            }
        }

        return left; // or right, since left == right
    }

    // Count how many pairs have distance <= mid
    private int countPairs(int[] nums, int mid) {
        int count = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > mid) {
                left++;
            }
            count += right - left;
        }

        return count;
    }
}
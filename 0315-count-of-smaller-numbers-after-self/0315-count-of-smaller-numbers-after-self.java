class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Step 1: Coordinate compression
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        
        // Map each number to its compressed index
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < sortedNums.length; i++) {
            numToIndex.put(sortedNums[i], i + 1);  // 1-based index
        }
        
        // Step 2: Using a Binary Indexed Tree (BIT)
        int[] BIT = new int[sortedNums.length + 1];  // BIT array
        for (int i = n - 1; i >= 0; i--) {
            // Query the BIT for the count of elements smaller than current
            int idx = numToIndex.get(nums[i]);
            result[i] = queryBIT(BIT, idx - 1);
            
            // Update BIT with the current element
            updateBIT(BIT, idx);
        }
        
        // Convert result to List and return
        List<Integer> resultList = new ArrayList<>();
        for (int r : result) {
            resultList.add(r);
        }
        return resultList;
    }

    // Update the BIT with the element at index idx
    private void updateBIT(int[] BIT, int idx) {
        while (idx < BIT.length) {
            BIT[idx]++;
            idx += idx & -idx;  // Move to next node in the BIT
        }
    }

    // Query the BIT for the sum up to index idx
    private int queryBIT(int[] BIT, int idx) {
        int sum = 0;
        while (idx > 0) {
            sum += BIT[idx];
            idx -= idx & -idx;  // Move to parent node in the BIT
        }
        return sum;
    }
}
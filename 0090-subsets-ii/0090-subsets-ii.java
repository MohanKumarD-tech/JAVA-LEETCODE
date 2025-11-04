class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        subset(0, nums, res, new ArrayList<>());
        return res;
    }

    private void subset(int i, int[] nums, List<List<Integer>> result, List<Integer> list) {
        result.add(new ArrayList<>(list));
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }
            list.add(nums[j]);
            subset(j + 1, nums, result, list);
            list.remove(list.size() - 1);
        }
    }
}
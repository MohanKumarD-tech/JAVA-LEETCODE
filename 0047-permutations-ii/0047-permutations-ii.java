class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        permute(0, nums, ans);
        return ans;
    }

    private void swap(int i, int j, int[] arr){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private void permute(int ind, int[] nums, List<List<Integer>> ans){

        if(ind == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int num : nums) temp.add(num); 
            ans.add(new ArrayList<>(temp));
            return;
        }

        Set<Integer> set = new HashSet<>();
        for(int i = ind; i < nums.length; i++){
            if(set.contains(nums[i])) continue;
            set.add(nums[i]);

            swap(i, ind, nums);
            permute(ind + 1, nums, ans);
            swap(i, ind, nums);
        }
        
    }
}
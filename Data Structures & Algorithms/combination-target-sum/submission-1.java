class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, target, nums, new ArrayList<>(), ans);
        return ans;
    }

    public void helper(int i, int target, int[] nums, List<Integer> list, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList(list));
            return;
        }
        if(i == nums.length){
            return;
        }

        helper(i+1, target, nums, list, ans);
        if(nums[i] <= target){
            list.add(nums[i]);
            helper(i, target - nums[i], nums, list, ans);
            list.remove(list.size()-1);
        }
    }
}

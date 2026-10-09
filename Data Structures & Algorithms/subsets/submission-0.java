class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        helper(0, nums, new ArrayList(), ans);
        return ans;
    }

    public void helper(int i, int[] nums, List<Integer> list, List<List<Integer>> ans){
        if(i == nums.length){
            ans.add(new ArrayList(list));
            return;
        }

        list.add(nums[i]);
        helper(i+1, nums, list, ans);
        list.remove(list.size()-1);
        helper(i+1, nums, list, ans);
    }
}

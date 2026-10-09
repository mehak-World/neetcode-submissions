class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();
        helper(0, nums, new ArrayList(), ans);
        return ans;
    }

    public void helper(int i, int[] nums, List<Integer> list, List<List<Integer>> ans){
        ans.add(new ArrayList(list));

        for(int j = i; j < nums.length; j++){
            if(j != i && nums[j] == nums[j-1]) continue;

            list.add(nums[j]);
            helper(j+1, nums, list, ans);
            list.remove(list.size()-1);
        }
    }
}

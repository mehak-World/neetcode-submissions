class Solution {
    public int rob(int[] nums) {
        int n = nums.length; // total houses
        int[] dp = new int[n];

        for(int i = 0; i < n; i++){
            dp[i] = -1;
        }

        return helper(0, nums, dp);
    }

    public int helper(int i, int[] nums, int[] dp){
        if(i >= nums.length) return 0;

        if(dp[i] != -1) return dp[i];

        return dp[i] = Math.max(nums[i] + helper(i+2, nums, dp), helper(i+1, nums, dp));
    }
}

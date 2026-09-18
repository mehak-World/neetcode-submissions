class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < 2; j++){
                dp[i][j] = -1;
            }
        }

        return helper(0, nums, 1, dp);
    }

    public int helper(int i, int[] nums, int canTakeLast, int[][] dp){
        if(i >= nums.length) return 0;

        if(dp[i][canTakeLast] != -1) return dp[i][canTakeLast];

        if(i == 0){
            return dp[i][canTakeLast] = Math.max(nums[i] + helper(i+2, nums, 0, dp), helper(i+1, nums, 1, dp));
        }

        if(i == nums.length-1){
            // last house
            // can only take if first is not taken
            if(canTakeLast == 1) return dp[i][canTakeLast] = nums[i];
            else return dp[i][canTakeLast] = 0;
        }

        return dp[i][canTakeLast] = Math.max(nums[i] + helper(i+2, nums, canTakeLast, dp), helper(i+1, nums, canTakeLast, dp));
    }
}

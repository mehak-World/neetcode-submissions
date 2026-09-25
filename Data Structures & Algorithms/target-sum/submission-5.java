class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
    
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        if ((target + sum) < 0) return 0;
        if((target + sum) % 2 != 0) return 0;

        int final_target = (target + sum)/2;

        int[][] dp = new int[n+1][final_target+1];

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }

        return helper(n, final_target, nums, dp);
    }

    public int helper(int n, int target, int[] nums, int[][] dp){
        if(n == 0){
        return target == 0 ? 1 : 0;
    }

        if(dp[n][target] != -1) return dp[n][target];

        int ways = helper(n-1, target, nums, dp);
        if(nums[n-1] <= target){
            ways += helper(n-1, target - nums[n-1], nums, dp);
        }

        return dp[n][target] = ways;
    }
}

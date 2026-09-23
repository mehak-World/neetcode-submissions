class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums){
            sum += num;
        }

        if(sum % 2 == 1) return false;
        int target = sum/2;
        int n = nums.length;
        Boolean[][] dp = new Boolean[n+1][target+1];

        return helper(n, target, nums, dp);
    }

    public boolean helper(int n, int target, int[] nums, Boolean[][] dp){
        if(target == 0) return true;
        if(n == 0) return false;

        if(dp[n][target] != null) return dp[n][target];

        boolean notTake = helper(n-1, target, nums, dp);
        boolean take = false;
        if(nums[n-1] <= target){
            take = helper(n-1, target-nums[n-1], nums, dp);
        }

        return dp[n][target] = take || notTake;
    }
}

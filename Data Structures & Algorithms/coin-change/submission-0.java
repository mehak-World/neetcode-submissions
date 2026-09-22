class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        // initialize dp
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= amount; j++){
                dp[i][j] = -1;
            }
        }

        int ans = helper(0, amount, coins, dp) ;
        return ans == Integer.MAX_VALUE ? -1: ans;
    }

    public int helper(int i, int amt, int[] coins, int[][] dp){
        if(amt == 0) return 0;

        if(i == coins.length) return Integer.MAX_VALUE;

        if(dp[i][amt] != -1) return dp[i][amt];

        int minCoins = helper(i+1, amt, coins, dp);

        if(coins[i] <= amt){
            int cns = helper(i, amt - coins[i], coins, dp);
            if(cns != Integer.MAX_VALUE){
                minCoins = Math.min(minCoins, 1 + cns);
            }
            
        }

        return dp[i][amt] = minCoins;
    }
}

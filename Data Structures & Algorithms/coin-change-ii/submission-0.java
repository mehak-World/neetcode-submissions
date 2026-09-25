class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }

        return helper(n, amount, coins, dp);
    }

    public int helper(int n, int amt, int[] coins, int[][] dp){
        if(amt == 0) return 1;
        if(n == 0) return 0;

        if(dp[n][amt]!= -1) return dp[n][amt];

        int ways = helper(n-1, amt, coins, dp);
        if(coins[n-1] <= amt){
            ways += helper(n, amt - coins[n-1], coins, dp);
        }

        return dp[n][amt] = ways;
    }
}

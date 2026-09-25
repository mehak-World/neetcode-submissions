class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }

        return helper(0, 1, prices, dp);
    }

    public int helper(int i, int canBuy, int[] prices, int[][] dp){
        if(i >= prices.length) return 0;

        if(dp[i][canBuy] != -1) return dp[i][canBuy];

        int profit = 0;
        if(canBuy == 1){
            profit = Math.max(-prices[i] + helper(i+1, 0, prices, dp), helper(i+1, 1, prices, dp));
        }
        else{
            profit = Math.max(prices[i] + helper(i+2, 1, prices, dp), helper(i+1, 0, prices, dp));
        }

        dp[i][canBuy] = profit;
        return profit;
    }
}

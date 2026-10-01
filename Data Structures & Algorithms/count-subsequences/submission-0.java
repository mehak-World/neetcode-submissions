class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m+1][n+1];

        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                dp[i][j] = -1;
            }
        }

        return helper(m, n, s, t, dp);
    }

    public int helper(int m, int n, String s, String t, int[][] dp){
            if(n == 0) return 1;
            if(m == 0) return 0;

            if(dp[m][n] != -1) return dp[m][n];

            int ways = helper(m-1, n, s, t, dp);
            if(s.charAt(m-1) == t.charAt(n-1)){
                ways += helper(m-1, n-1, s, t, dp);
            }

            return dp[m][n] = ways;
        }
}

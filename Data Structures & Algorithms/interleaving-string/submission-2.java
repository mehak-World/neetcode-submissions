class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != (s1.length() + s2.length())) return false;

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                dp[i][j] = -1;
            }
        }

        return helper(0, 0, s1, s2, s3, dp);
    }

    public boolean helper(int i, int j, String s1, String s2, String s3, int[][] dp){
        if(i + j == s1.length() + s2.length()) return true;

        if(dp[i][j] != -1) return dp[i][j] == 1;

        int k = i+j;
        if(i < s1.length() && j < s2.length() &&                    s3.charAt(k) == s1.charAt(i) && s3.charAt(k) == s2.charAt(j)){
            boolean ans = helper(i+1, j, s1, s2, s3, dp) || helper(i, j+1, s1, s2, s3, dp);
            dp[i][j] = ans == true ?  1: 0;
            return ans;
        }
        else if(i < s1.length() && s3.charAt(k) == s1.charAt(i)){
            boolean ans = helper(i+1, j, s1, s2, s3, dp);
            dp[i][j] = ans == true ?  1: 0;
            return ans;
        }
        else if(j < s2.length() && s3.charAt(k) == s2.charAt(j)){
            boolean ans = helper(i, j+1, s1, s2, s3, dp);
            dp[i][j] = ans == true ? 1 : 0;
            return ans;
        }
        else{
            dp[i][j] = 0;
            return false;
        }
    }
}

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++){
            dp[i][i] = 1;
        }

        int maxLen = 0;
        int maxi = 0;
        int maxj = 0;

        for(int i = n-2; i >= 0; i--){
            for(int j = i+1; j < n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(i+1 > j-1){
                        dp[i][j] = 1;
                        if(j - i + 1 > maxLen){
                            maxLen = j-i+1;
                            maxi = i;
                            maxj = j;
                        }
                    }
                    else{
                        if(dp[i+1][j-1] == 0) dp[i][j] = 0;
                        else{
                            dp[i][j] = 1;
                            if(j - i + 1 > maxLen){
                                maxLen = j-i+1;
                                maxi = i;
                                maxj = j;
                            }
                        }
                    }
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }

        return s.substring(maxi, maxj+1);
    }
}

class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int cnt = 0;

        for(int i = 0; i < n; i++){
            dp[i][i] = 1;
            cnt++;
        }

        for(int i = n-2; i >= 0; i--){
            for(int j = i+1; j < n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(i+1 > j-1){
                        dp[i][j] = 1;
                        cnt++;
                    }
                    else{
                        if(dp[i+1][j-1] == 0) dp[i][j] = 0;
                        else{
                            dp[i][j] = 1;
                            cnt++;
                        }
                    }
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }

        return cnt;
    }
}

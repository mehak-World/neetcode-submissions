class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        Set<String> set = new HashSet();
        for(int i = 1; i <= 26; i++){
            set.add("" + i);
        }
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }

        return helper(s, 0, s.length()-1, set, dp);
    }

    public int helper(String s, int i, int j, Set<String> set, int[][] dp){
        if(i > j) return 1;
        if(i == j){
            if(s.charAt(i) == '0') return 0;
            return 1;
        }

        if(dp[i][j] != -1) return dp[i][j];

        int cnt = 0;
        for(int k = i+1; k <= j+1; k++){
            if(set.contains(s.substring(i, k))){
                cnt += helper(s, k, j, set, dp);
            }
        }

        dp[i][j] = cnt;

        return cnt;
    }
}

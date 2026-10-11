class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++){
            dp[i][i] = 1;
        }

        for(int i = n-2; i >= 0; i--){
            for(int j = i+1; j < n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j-i+1 == 2){
                        dp[i][j] = 1;
                    }
                    else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }

        List<List<String>> ans = new ArrayList();
        helper(0, n-1, s, dp, new ArrayList(), ans);

        return ans;
    }

    public void helper(int i, int j, String s, int[][] dp, List<String> list, List<List<String>> ans){
        if(i > j){
            ans.add(new ArrayList(list));
            return;
        };

        for(int k = i; k <= j; k++){
            if(dp[i][k] == 1){
                list.add(s.substring(i, k+1));
                helper(k+1, j, s, dp, list, ans);
                list.remove(list.size()-1);
            }
        }
    }
}

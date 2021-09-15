class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp =  new int[word1.length()+1][word2.length()+1];
        int m = word1.length(), n = word2.length();
        for (int i = 1; i <= m; ++i){
            for (int j = 1; j <= n; ++j){
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return (m - dp[m][n]) + (n - dp[m][n]);
    }
}
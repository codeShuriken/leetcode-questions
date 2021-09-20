class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int n = s.length();
        int start = 0, end = 0;
        for (int i = n-1; i >= 0; --i){
            for (int j = i+1; j < n; ++j){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = (j - i <= 2 || dp[i+1][j-1]);
                    if (dp[i][j] && j - i > end - start){
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end+1);
    }
}
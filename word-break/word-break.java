class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        
        for (int i = 0; i < s.length(); ++i){
            for (int j = 0; j <= i; ++j){
                if (dp[j] && words.contains(s.substring(j, i+1))){
                    dp[i+1]  = true;
                    break;
                }
            }
        }
        
        return dp[n];
    }
}
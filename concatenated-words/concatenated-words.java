class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0)return res;

        Set<String> set = new HashSet<>();
        
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        for (String word : words){
            if (canConcat(word, set)){
                res.add(word);
            }
            set.add(word);
        }
        
        return res;
    }
    
    private boolean canConcat(String word, Set<String> words){
        if (word == null || word.length() == 0)return false;
        int n = word.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 0; i < word.length(); ++i){
            for (int j = 0; j <= i; ++j){
                if (dp[j] && words.contains(word.substring(j, i+1))){
                    dp[i+1] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
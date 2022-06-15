class Solution {
    public int longestStrChain(String[] words) {
        if (words == null || words.length == 0)return 0;
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        Map<String, Integer> map = new HashMap<>();
        int maxLen = 0, best;
        for (int i = 0; i < words.length; ++i){
            String word = words[i];
            best = 0;
            for (int j = 0; j < word.length(); ++j){
                String newWord = word.substring(0, j) + word.substring(j+1);
                best = Math.max(best, map.getOrDefault(newWord, 0) + 1);
            }
            maxLen = Math.max(best, maxLen);
            map.put(word, best);
        }
        return maxLen;
    }
}
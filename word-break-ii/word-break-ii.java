class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, new HashSet<>(wordDict), new HashMap<>());
    }
    
    private List<String> dfs(String s, Set<String> words, Map<String, List<String>> cache){
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0){
            res.add("");
            return res;
        }
        
        if (cache.containsKey(s))return cache.get(s);
        
        for (String word : words){
            if (s.startsWith(word)){
                List<String> temp = dfs(s.substring(word.length()), words, cache);
                for (String t : temp){
                    res.add(word + (t.length() == 0 ? "" : " " + t));
                }
            }
        }
        
        cache.put(s, res);
        return res;
    }
}
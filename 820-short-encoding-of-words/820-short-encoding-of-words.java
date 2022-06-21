class Solution {
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int i = 1; i < word.length(); ++i) {
                set.remove(word.substring(i));
            }
        }
        
        int total = set.size();
        for (String s : set)total+=s.length();
        return total;
    }
    
}


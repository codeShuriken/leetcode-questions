class WordFilter {

    class Trie{
        Trie[] children = new Trie[27];
        int weight;
    }
    
    Trie root = new Trie();
    
    public WordFilter(String[] words) {
        for (int i = 0; i < words.length; ++i) {
            String word = words[i] + "{";
            for (int j = 0; j < word.length(); ++j) {
                Trie node = root;
                for (int k = j; k < 2 * word.length(); ++k) {
                    char c  = word.charAt(k % word.length());
                    if (node.children[c - 'a'] == null)
                        node.children[c-'a'] = new Trie();
                
                    node = node.children[c-'a'];
                    node.weight = i;
                }
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        String str = suffix + "{" + prefix;
        Trie node = root;
        for (char c : str.toCharArray()) {
            if (node.children[c -'a'] == null)
                return -1;
            node = node.children[c -'a'];
        }
        return node.weight;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
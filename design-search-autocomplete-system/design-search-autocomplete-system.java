class AutocompleteSystem {
    Map<String, Integer> countMap = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    Trie trie = new Trie();

    
    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; ++i){
            countMap.put(sentences[i], times[i]);
        }
        
        trie.addWords(sentences);
    }
    
    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if (c == '#'){
            String key = sb.toString();
            sb = new StringBuilder();
            if (!countMap.containsKey(key))
                trie.addWord(key);
            countMap.put(key, countMap.getOrDefault(key, 0)+1);
        }else{
            sb.append(c);
            res = trie.searchInput(sb.toString());
            Collections.sort(res, (a, b) -> {
                int countA = countMap.get(a);
                int countB  = countMap.get(b);
                if (countA == countB){
                    return a.compareTo(b);
                }
                return countB - countA;
            });
            
            res =  res.subList(0, Math.min(3, res.size()));
        }
        
        return res;
    }
}

class Trie{
    TrieNode root;
    Trie(){
        root = new TrieNode();
    }
    
    void addWords(String[] words){
        for (String word : words){
            addWord(word);
        }
    }
    
    void addWord(String word){
        TrieNode node = this.root;
        for (char  c : word.toCharArray()){
            if (!node.children.containsKey(c))
                node.children.put(c, new TrieNode());
            node = node.children.get(c);
            node.words.add(word);
        }
    }
    
    List<String> searchInput(String prefix){
        TrieNode node = this.root;
        
        for (char c : prefix.toCharArray()){
            if (!node.children.containsKey(c))
                return new ArrayList<>();
            node = node.children.get(c);
        }
        
        return node.words;
    }
    
}

class TrieNode{
    Map<Character, TrieNode> children;
    List<String> words = new ArrayList<>();
    
    TrieNode(){
        children = new HashMap<>();
    }
    
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
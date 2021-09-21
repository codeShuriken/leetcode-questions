class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        
        Trie trie = new Trie();
        for (String word : words){
            trie.addWord(word);
        }
        int m = board.length, n = board[0].length;
        
        TrieNode node = trie.root;
        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                if (node.children.containsKey(board[i][j])){
                    dfs(board, i, j, node, res);
                }
            }
        }
        
        return res;
    }
    
    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> res){
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '*' || !node.children.containsKey(board[i][j]))
            return;
        
        node = node.children.get(board[i][j]);
        if (!node.word.equals("")){
            res.add(node.word);
            node.word = "";
        }
        
        char c = board[i][j];
        board[i][j] = '*';
        
        dfs(board, i+1, j, node, res);
        dfs(board, i-1, j, node, res);
        dfs(board, i, j+1, node, res);
        dfs(board, i, j-1, node, res);
        
        board[i][j] = c;
    }
}

class TrieNode{
    Map<Character, TrieNode> children = new HashMap<>();
    String word = "";
}
class Trie{
    TrieNode root = new TrieNode();
    
    void addWord(String word){
        TrieNode node = root;
        for (char c : word.toCharArray()){
            if (!node.children.containsKey(c)){
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        
        node.word = word;
    }
}
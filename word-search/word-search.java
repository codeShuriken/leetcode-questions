class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                if (word.charAt(0) == board[i][j]){
                    if (dfs(board, i, j, word, 0))
                        return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, int i, int j, String word, int index){
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || 
            board[i][j] != word.charAt(index))
            return false;
        
        if (index == word.length() - 1)
            return true;
        char c  = board[i][j];
        board[i][j] = '*';
        
        boolean exists = dfs(board, i+1, j, word, index+1) || dfs(board, i-1, j, word, index+1)
             || dfs(board, i, j+1, word, index+1) || dfs(board, i, j-1, word, index+1);
        
        
        board[i][j] = c;
        return exists;
    }
}
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                char charToCheck = board[i][j];

                board[i][j] = '.';
                if (charToCheck != '.' && !isValid(board, charToCheck, i, j))
                    return false;
                board[i][j]  = charToCheck;
            }
        }
            
        return true;
    }
    
    private boolean isValid(char[][] board, char charToPlace, int row, int col){
       for (int i =0; i < board.length; ++i){
            if (board[row][i] == charToPlace) return false;
           if (board[i][col] == charToPlace)return false;
       }
        
        int gridSize = (int)Math.sqrt(board.length);
        int topLeftRow = 3 * (row / gridSize);
        int topLeftCol = 3 * (col / gridSize);
        
        for (int i = 0; i < gridSize; ++i){
            for (int j = 0; j < gridSize; ++j){
                if (board[topLeftRow + i][topLeftCol + j] == charToPlace){
                    return false;
                }
            }
        }
        
        return true;
    }
}
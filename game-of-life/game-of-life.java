class Solution {
    private static final int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};
    public void gameOfLife(int[][] board) {
        //0, 2 -> dead/future dead
        //1,3 -> live/future live
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                int numOnes = countOnes(board, i, j);
                if (board[i][j] != 0 && (numOnes < 2 || numOnes > 3))board[i][j]  = 2;
                 if (board[i][j] == 0 && numOnes == 3) board[i][j] = 3;
            }
        }
                
        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                board[i][j] %= 2;
            }
        }
    }
    
    public int countOnes(int[][] board, int i, int j){
        int count = 0;
        for (int[] dir : dirs){
            int x = i + dir[0], y = j  + dir[1];
            if (x >= 0 && y >= 0 && x < board.length && y < board[0].length && 
                (board[x][y]==1 || board[x][y] == 2)){
                ++count;
            }
        }
        
        return count;
    }
}
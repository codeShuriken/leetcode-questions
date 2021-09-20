class Solution {
    int empty = 0, res = 0, sx, sy;
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                if (grid[i][j] == 0)
                    ++empty;
                else if (grid[i][j] == 1){
                    sx = i;
                    sy = j;
                    ++empty;
                }
                    
            }
        }
        
        dfs(grid, sx, sy);
        return res;
    }
    
    private void dfs(int[][] grid, int i, int j){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] < 0)
            return;
        
        if (grid[i][j] == 2){
            if (empty == 0)
                ++res;
            return;
        }
        
        --empty;
        grid[i][j] = -2;
        
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
        
        ++empty;
        grid[i][j] = 0;
        
    }
}
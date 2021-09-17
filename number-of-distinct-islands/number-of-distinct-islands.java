class Solution {
    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                if (grid[i][j] == 1){
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, 0, 0, sb);
                    if (!set.contains(sb.toString())){
                        set.add(sb.toString());
                    }
                }
            }
        }
        return set.size();
    }
    
    private void dfs(int[][] grid, int i, int j, int xDir, int yDir, StringBuilder sb){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1)
            return;
        
        grid[i][j] = 0;
        sb.append(xDir + "," + yDir + ";");
        
        for (int[] dir : dirs){
            int newX = dir[0] + i, newY = dir[1] + j;
            dfs(grid, newX, newY, xDir + dir[0], yDir + dir[1], sb);
        }
    }
}
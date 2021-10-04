class Solution {
    public int islandPerimeter(int[][] grid) {
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int cnt = 0;
        
        int m = grid.length, n = grid[0].length;
        
        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                if (grid[i][j] == 1){
                    for (int[] dir : dirs){
                        int newX = i + dir[0], newY = j + dir[1];
                        if (newX < 0 || newY < 0 || newX >= m || newY >= n || grid[newX][newY] != 1)
                            cnt++;
                    }
                }
            }
        }
        
        return cnt;
    }
}
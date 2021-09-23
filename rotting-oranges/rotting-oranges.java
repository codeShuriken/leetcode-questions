class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0)return 0;
        Queue<int[]> q  = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        
        int freshOranges = 0;
        
        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                if (grid[i][j] == 1){
                    freshOranges++;
                }else if (grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                }
            }
        }
        
        if (freshOranges == 0)return 0;
        int time = 0;
        int[][] dirs  = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        // boolean[][] visited = new boolean[m][n];
        
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; ++i){
                int[] cur = q.poll();
                for (int[] dir : dirs){
                    int x  = dir[0] + cur[0], y = cur[1] + dir[1];
                    if (isValid(grid, x, y) && grid[x][y] == 1){
                        --freshOranges;
                        grid[x][y] = 2;
                        q.offer(new int[]{x, y});
                    }
                }
            }
            time++;
        }
        
        return freshOranges == 0 ? time-1 : -1;
    }
    
    private boolean isValid(int[][] grid, int i, int j){
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length;
    }
}
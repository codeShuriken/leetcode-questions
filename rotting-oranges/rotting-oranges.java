class Solution {
    public int orangesRotting(int[][] grid) {
        int freshOranges = 0;
        Queue<int[]> q  = new LinkedList<>();
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                if (grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                }else if (grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }
        
        if (freshOranges == 0)return 0;
        int steps = 0;
        
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; ++i){
                int[] cur = q.poll();
                for (int[] dir : dirs){
                    int newX = dir[0] + cur[0], newY = dir[1] + cur[1];
                    if (isValid(grid, newX, newY) && grid[newX][newY] == 1){
                        --freshOranges;
                        grid[newX][newY] = 2;
                        q.offer(new int[]{newX, newY});
                    }
                }
            }
            ++steps;
        }
        
        return freshOranges != 0 ? -1 : steps-1;
        
    }
    
    private boolean isValid(int[][] grid, int i, int j){
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length;
    }
}
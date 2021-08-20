class Solution {
    public int getFood(char[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < grid.length; ++i){
            for (int j = 0; j < grid[0].length; ++j){
                if (grid[i][j] == '*'){
                    q.offer(new int[]{i,j});
                    return bfs(grid, q);
                }
            } 
        }        
        return -1;
    }
    
    private int bfs(char[][] grid, Queue<int[]> q){
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int level = 0;
        //boolean[][] visited  = new boolean[grid.length][grid[0].length];
    
        while (!q.isEmpty()){
            int size  = q.size();
            for (int i = 0; i < size; ++i){
                int[] cur = q.poll();
                if (grid[cur[0]][cur[1]] == '#')return level;
                if (grid[cur[0]][cur[1]] == 'V')continue;
                grid[cur[0]][cur[1]] = 'V';
                for (int[] dir : dirs){
                    int x = cur[0] + dir[0], y = cur[1] + dir[1];
                    if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length &&
                       grid[x][y] != 'X' && grid[x][y] != 'V'){
                        //!visited[x][y]){
                            q.offer(new int[]{x, y});
                            // visited[x][y]  = true;
                        }
                    }
                }
            ++level;
        }
        
        return -1;
    }
}
class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> q  = addGates(rooms);
        
        int[][] dirs  = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty()){
            int size = q.size();
            for (int i =0; i < size; ++i){
                int[] cur = q.poll();
                for (int[] dir : dirs){
                    int x = cur[0] + dir[0], y = cur[1] + dir[1];
                    if (isValid(rooms, x, y) && 
                        rooms[x][y] > rooms[cur[0]][cur[1]] + 1){
                        
                        rooms[x][y] = rooms[cur[0]][cur[1]] + 1;
                        q.offer(new int[]{x, y});
                        
                    }
                }
            }
        }
    }
    
    private boolean isValid(int[][] rooms, int row, int col){
        return row >= 0 && col >= 0 && row < rooms.length && col < rooms[0].length;
    }
    
    private Queue<int[]> addGates(int[][] rooms){
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < rooms.length; ++i){
            for (int j = 0; j < rooms[0].length; ++j){
                if (rooms[i][j] == 0){
                    q.offer(new int[]{i, j});
                }
            }
        }
        return q;
    }
}
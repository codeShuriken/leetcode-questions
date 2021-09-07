class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        Queue<int[]> q  = new LinkedList<>();
        int oldColor = image[sr][sc];
                if (oldColor == newColor)return image;

        
        q.offer(new int[]{sr, sc});
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        while (!q.isEmpty()){
            int[] cur = q.poll();
            image[cur[0]][cur[1]] = newColor;
            for (int[] dir : dirs){
                int x = cur[0] + dir[0], y = cur[1] + dir[1];
                if (x >= 0 && y >= 0 && x < image.length && y < image[0].length && 
                   image[x][y] == oldColor){
                    q.offer(new int[]{x, y});
                }
            }
        }
        
        return image;
        
        
    }
}
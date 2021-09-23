class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
       
        int m = matrix.length, n = matrix[0].length;
        int max = 0;
        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                max = Math.max(max, dfs(matrix, i, j, m, n, dp, Integer.MIN_VALUE));
            }
        }
        return max;
    }
    
    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    public int dfs(int[][] matrix, int i, int j, int m, int n, int[][] dp, int prev){
        if (i < 0 || j < 0 || i >= m || j >= n || prev >= matrix[i][j])return 0;
        if (dp[i][j] != 0)return dp[i][j];
        
        int cache = 0;
        for (int[] d : dirs){
            cache = Math.max(cache, 1 + dfs(matrix, i+d[0], j+d[1], m,n,dp, matrix[i][j]));
        }
        
        //dp[i][j] = Math.max(dp[i][j],cache);
        return dp[i][j] = cache;
    }
}
class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int r1 = mat1.length, c1 = mat1[0].length, r2 = mat2.length, c2 = mat2[0].length;
        int[][] res = new int[r1][c2];
        
        for (int i = 0; i < r1; ++i){
            for (int j = 0; j < c1; ++j){
                if (mat1[i][j] != 0){
                    for (int k = 0; k < c2; ++k){
                        if(mat2[j][k] != 0){
                            res[i][k] += mat1[i][j] * mat2[j][k]; 
                         }
                    }
                }
                
            }
        }
        
        return res;
        
    }
}
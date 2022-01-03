class Solution {
    public int findJudge(int n, int[][] trust) {
        int[][] degrees = new int[n+1][2];
        for (int[] t : trust){
            degrees[t[1]][0]++;
            degrees[t[0]][1]++;
        }
        
        for (int i = 1; i < degrees.length; ++i){
            if (degrees[i][0] == n-1 && degrees[i][1] == 0)return i;
        }
        
        return -1;
    }
}
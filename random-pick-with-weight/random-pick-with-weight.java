class Solution {
    
    int max = 0;
    int[] weights;
    Random r = new Random();
    public Solution(int[] w) {
        max = w[0];
        weights = new int[w.length];
        weights[0]=max;
        for (int i=1; i<weights.length; ++i){
            weights[i] += weights[i-1] + w[i];
            max += w[i];
        }
    }
    
    public int pickIndex() {
        int num = r.nextInt(max)+1;
        int left = Arrays.binarySearch(weights, num);
        if (left < 0)left = -left-1;
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
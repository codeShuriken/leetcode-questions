class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                                                          if (a[2] == b[2])
                                                              return a[0] - b[0];
                                                          return a[2] - b[2];
                                                      });   
        
        for (int[] trip : trips){
            pq.offer(new int[]{trip[0], trip[1], trip[1]});
            pq.offer(new int[]{-trip[0], trip[2], trip[2]});
        }
        
        int curCap = 0;
        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            curCap += cur[0];
            if (curCap > capacity)return false;
        }
        
        return true;
    }
}
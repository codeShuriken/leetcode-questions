class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->
                                                      {
                                                          if (a[1] == b[1])
                                                              return a[0] - b[0];
                                                          return a[1] - b[1];      
                                                      });
        
        for (int[] trip : trips){
            pq.offer(new int[]{trip[0], trip[1]});
            pq.offer(new int[]{-trip[0], trip[2]});
        }
        
        int curPassengers = 0;
        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            curPassengers += cur[0];
            if (curPassengers > capacity){
                return false;
            }
        }
        
        return true;
        
    }
}
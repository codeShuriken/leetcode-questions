class Solution {
    public int connectSticks(int[] sticks) {
        if (sticks.length == 1)return 0;
        if (sticks.length == 2)return sticks[0] + sticks[1];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int stick : sticks){
            pq.offer(stick);
        }
        
        int total  = 0;
        while (pq.size() > 1){
            int a = pq.poll(), b = pq.poll();
            total += (a+b);
            pq.offer(a + b);
        }
        
        return total;
        
    }
}
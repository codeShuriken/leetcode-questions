class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int numRooms = 0;
        for (int[] interval : intervals){
            if (pq.isEmpty() || pq.peek() > interval[0]){
                ++numRooms;
            }else{
                pq.poll();
            }
            
            pq.offer(interval[1]);
        }
        return numRooms;
        
    }
}
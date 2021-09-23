class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]>  pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
        for (int[] boxType : boxTypes){
            pq.offer(boxType);
        }
        
        int maxUnits = 0;
        while (!pq.isEmpty() && truckSize > 0){
            int[] curBox = pq.poll();
            int numBoxes = curBox[0];
            int boxUnits = curBox[1];
            
            int numBoxesTaken = Math.min(curBox[0], truckSize);
            maxUnits += boxUnits * numBoxesTaken;
            if (numBoxes > truckSize){
                curBox[0] -= truckSize;
                pq.offer(curBox);
            }
            
            truckSize -= numBoxesTaken;
        }
        
        return maxUnits;
    }
}
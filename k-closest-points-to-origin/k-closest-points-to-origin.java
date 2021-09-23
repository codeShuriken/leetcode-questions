class Solution {
    public int[][] kClosestSorted(int[][] points, int k) {
        Arrays.sort(points, (a,b) -> (a[0]*a[0]+a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]));
        return Arrays.copyOfRange(points, 0, k);
    }
    
    public int[][] kClosestPQ(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (-1)*((a[0]*a[0]+a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1])));
        
        for (int[] point : points){
            pq.offer(point);
            if (pq.size() > k){
                pq.poll();
            }
        }
        
        int[][] res = new int[k][2];
        for (int i = 0; i < k; ++i){
            res[i] = pq.poll();
        }
        
        return res;
    }
    
    public int[][] kClosest(int[][] points, int k) {
        sort(points, 0, points.length-1, k);
        return Arrays.copyOfRange(points, 0, k);
    }
    
    private void sort(int[][] points, int start, int end, int k){
        while (start <= end){
            int mid = partition(points, start, end);
            if (mid == k)return;
            else if (mid < k)start = mid + 1;
            else end = mid - 1;
        }
    }
    
    private int partition(int[][] points, int start, int end){
        
        int partitionIndex = start + ((int)(Math.random() * (end - start + 1)));
        swap(points, start, partitionIndex);
        
        int index = start + 1;
        for (int i = start + 1; i <= end; ++i){
            if (dist(points[start], points[i]) > 0){
                swap(points, index++, i);
            }
        }
        
        swap(points, start, --index);
            
        return index;
        
        
    }
    
    private void swap(int[][] points, int i, int j){
        int[] temp = points[i];
        points[i]  = points[j];
        points[j]  = temp;
    }
    
    private int dist(int[] a, int[] b){
        return (a[0]*a[0]+a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]);
    }
}
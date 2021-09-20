class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; ++i){
            graph.put(i, new ArrayList<>());
        }
        
        for (int[] pre : prerequisites){
            int from = pre[1], to = pre[0];
            graph.get(from).add(to);
            indegree[to]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i){
            if (indegree[i] == 0)
                q.offer(i);
        }
        
        int courses = 0;
        while (!q.isEmpty()){
            int cur = q.poll();
            courses++;
            for (int neighbour : graph.getOrDefault(cur, new ArrayList<>())){
                indegree[neighbour]--;
                if (indegree[neighbour] == 0)
                    q.offer(neighbour);
            }
        }
        
        return courses == numCourses;
    }
}
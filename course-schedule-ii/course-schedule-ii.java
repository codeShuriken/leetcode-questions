class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        
        for (int[] pre : prerequisites){
            int from = pre[1], to = pre[0];
            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(to);
            indegree[to]++;
        }
        
        List<Integer> res = new ArrayList<>();
        
        Queue<Integer> q = new LinkedList<>();
        for (int i =0; i < numCourses; ++i){
            if (indegree[i] == 0)q.offer(i);
        }
        
        while (!q.isEmpty()){
            int course = q.poll();
            res.add(course);
            if (graph.get(course) == null)continue;
            for (int neighbour : graph.get(course)){
                --indegree[neighbour];
                if (indegree[neighbour] == 0)
                    q.offer(neighbour);
            }
        }
        
        
        return res.size() == numCourses ? res.stream().mapToInt(Integer::intValue).toArray() : new int[0];
    }
}
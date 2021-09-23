class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // We record the timestamp that we visit each node. 
          //For each node, we check every neighbor except its parent and return a smallest timestamp in all its neighbors. 
        //If this timestamp is strictly less than the node's timestamp, we know that this node is somehow in a cycle. 
        //Otherwise, this edge from the parent to this node is a critical connection.
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (List<Integer> connection : connections){
            int u = connection.get(0), v = connection.get(1);
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        int[] time = new int[n];
        dfs(res, graph, 0, -1, 1, time);
        return res;
    }
    
    private int dfs(List<List<Integer>> res, Map<Integer, List<Integer>> graph, 
                   int node, int parent, int currentTimestamp, int[] time){
        time[node] = currentTimestamp;
        for (int v : graph.getOrDefault(node, new ArrayList<>())){
            if (v == parent)continue;
            if (time[v] > 0)time[node] = Math.min(time[node], time[v]);
            else time[node] = Math.min(time[node], dfs(res, graph, v, node, currentTimestamp+1, time));
                                       
            if (time[v] > currentTimestamp)res.add(Arrays.asList(node, v));
        }
             
        return time[node];
    }
}
class Solution {
    public int countComponents(int n, int[][] edges) {
        
        List<List<Integer>> g = new ArrayList<>();
        for (int i= 0; i < n; ++i){
            g.add(new ArrayList<>());
        }
        
        for (int[] edge : edges){
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
        }
        
        
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; ++i){
            if (!visited[i]){
                ++count;
                dfs(g, i, -1, visited);
            }
        }
        
        return count;
    }
    
    private void dfs(List<List<Integer>> g, int node, int parent, boolean[] visited){
        visited[node] = true;
        for (int v : g.get(node)){
            if (v == parent)continue;
            if (!visited[v]){
                dfs(g, v, node, visited);
            }
        }
    }
}
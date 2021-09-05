class Solution {
    int[] res, count;
    List<Set<Integer>> tree;
    int N;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        this.N = N;
        res = new int[N];
        count = new int[N];
        tree = new ArrayList<>();
        for (int i = 0; i < N; ++i){ 
            tree.add(new HashSet<>());
        }
        
        for (int[] edge : edges){
            int u = edge[0], v = edge[1];
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        
        dfs(0, -1);
        dfs2(0, -1);
        return res;
    }

    public void dfs(int root, int pre) {
       for (int i : tree.get(root)){
           if (i == pre)continue;
           dfs(i, root);
           count[root] += count[i];
           res[root] += res[i] + count[i];
       }
        
        count[root]++;
    }


    public void dfs2(int root, int pre) {
       for (int i : tree.get(root)){
           if (i == pre)continue;
           //Remove 1 to all the neighbors and add 1 to all others
           res[i] = res[root] - count[i] + (N - count[i]);
           dfs2(i, root);
       }
    }
}
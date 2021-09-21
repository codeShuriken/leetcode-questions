class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord))return new ArrayList<>();
        
        Map<String, List<String>> adjList = new HashMap<>();
        Map<String, Integer> dist = new HashMap<>();
        
        adjList.put(beginWord, new ArrayList<>());
        dist.put(beginWord, 0);
        
        for (String word : words){
            adjList.put(word, new ArrayList<>());
        }
        
        bfs(beginWord, endWord, words, adjList, dist); //to create adj list and dist map
        List<List<String>> res = new ArrayList<>();
        //dfs
        dfs(res, new ArrayList<>(), beginWord, endWord, adjList, dist);
        return res;   
    }
    
    private void bfs(String begin, String end, Set<String> words, Map<String, List<String>> adjList, Map<String, Integer> dist){
        Queue<String> q = new LinkedList<>();
        q.offer(begin);
        
        boolean isEnd = false;
        while (!q.isEmpty()){
            int size = q.size();
            
            for (int i = 0; i < size; ++i){
                String cur = q.poll();
                int curDist = dist.get(cur);
                
                List<String> neighbors = getNeighbors(cur, words);
                for (String neighbor : neighbors){
                    adjList.get(cur).add(neighbor);
                    if (!dist.containsKey(neighbor)){
                        dist.put(neighbor, curDist+1);
                        if (neighbor.equals(end))
                            isEnd = true;
                        else 
                            q.offer(neighbor);
                    }
                }
            }
            
            if (isEnd)break;
        }
    }
    
    private List<String> getNeighbors(String cur, Set<String> words){
        List<String> res = new ArrayList<>();
        for (int i = 0; i < cur.length(); ++i){
            char[] word  = cur.toCharArray();
            for (char c = 'a'; c <= 'z'; ++c){
                if (c == word[i])continue;
                word[i]  = c;
                String newWord = new String(word);
                if (words.contains(newWord))
                    res.add(newWord);
            }
        }
        return res;
    }
    
    
    private void dfs(List<List<String>> res, List<String> temp, String cur, String endWord, Map<String, List<String>> adjList, Map<String, Integer> dist){
        temp.add(cur);
        if (cur.equals(endWord)){
            res.add(new ArrayList<>(temp));
        }else{
            for (String v : adjList.get(cur)){
                if (dist.get(v) == dist.get(cur)+1){
                    dfs(res, temp, v, endWord, adjList, dist);
                }
            }
        }
        temp.remove(temp.size()-1);
    }

    
    
}
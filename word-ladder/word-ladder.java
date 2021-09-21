class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord))return 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        
        int level = 0;
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; ++i){
                String cur = q.poll();
                if (cur.equals(endWord))
                    return level+1;
                addWords(q, cur, words);
            }
            
            level++;
        }
        
        return 0;
    }
    
    
    private void addWords(Queue<String> q, String cur, Set<String> words){
        for (int i =0; i < cur.length(); ++i){
            char[] word = cur.toCharArray();
            for (char c = 'a'; c <= 'z'; ++c){
                if (c == word[i])
                    continue;
                
                word[i] = c;
                String newWord = new String(word);
                if (words.contains(newWord)){
                    q.offer(newWord);
                    words.remove(newWord);
                }
            }
        }
    }
}
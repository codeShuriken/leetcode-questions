class CombinationIterator {
    int len, size;
    Queue<String> q = new LinkedList<>();
    
    public CombinationIterator(String characters, int combinationLength) {
        len = 0;
        helper(characters.toCharArray(), combinationLength, 0, new StringBuilder());
        size = q.size();
    }
    
    private void helper(char[] ch, int len, int index, StringBuilder sb){
        if (sb.length() == len){
            q.offer(sb.toString());
            return;
        }
        
        int size = sb.length();
        for (int i = index; i < ch.length; ++i){
            sb.append(ch[i]);
            helper(ch, len, i+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        
    }
    
    public String next() {
        if (hasNext())
            return q.poll();
        return "";
    }
    
    public boolean hasNext() {
        return !q.isEmpty();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
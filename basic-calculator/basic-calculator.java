class Solution {
    public int calculate(String s) {
        Queue<Character> q = new LinkedList<>();
        for (char c : s.toCharArray())
           if (c != ' ') q.offer(c);
        
        q.offer('+');
        
        return calculate(q);
    }
    
    private int calculate(Queue<Character> q){
        int total = 0, prev = 0, num = 0;
        char sign = '+';
        
        while(!q.isEmpty()){
            char c = q.poll();
            if (c >= '0' && c <= '9')num = num*10 + c - '0';
            else if (c == '(')num = calculate(q);
            else{
                switch(sign){
                    case '+':
                        total += prev;
                        prev = num;
                        break;
                    case '-':
                        total += prev;
                        prev = -num;
                        break;
                }
                
                if (c == ')')break;
                sign = c;
                num = 0;
            }
        }
        
        
        
        return total + prev;
    }
}
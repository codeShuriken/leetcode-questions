class Solution {
    
    public int myAtoi(String s) {
        s = s.trim();
        if (s == null || s.length() == 0)return 0;
        boolean isNegative = false;
        double res = 0;
        if (s.charAt(0) == '-')
            isNegative = true;
        
        int startIndex = 0;
        if (s.charAt(startIndex) == '+' || s.charAt(startIndex) == '-')
            startIndex++;
        
        for (int i = startIndex; i < s.length(); ++i){
            if (s.charAt(i) < '0' || s.charAt(i) > '9')break;
            res = res * 10 + (s.charAt(i) - '0')%10;
        }
        
        if (isNegative)
            res = -1 * res;
                
        if (res > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        
        if (res < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        
        return (int)res;
    }
}
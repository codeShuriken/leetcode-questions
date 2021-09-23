class Solution {
    public String nearestPalindromic(String n) {
        long num  = Long.parseLong(n);
        if (n.length() == 1)return "" + (num-1);
        if (allNines(n))return "" + (num+2);
        if (num == 10 || (n.charAt(0) == '1' && Long.parseLong(n.substring(1)) == 0))
            return "" + (num-1);
        if ((num == 11) || (n.charAt(0) == '1' && Long.parseLong(n.substring(1)) == 1))
            return "" + (num-2);
        
        boolean isEven = n.length() % 2 == 0;
        
        String palindromeRoot = (isEven) ? n.substring(0, n.length()/2) : 
                                            n.substring(0, (n.length() + 1)/2);
        Long palindromeRootNum = Long.parseLong(palindromeRoot);
        
        
        long greaterNum = toPalindromeDigits("" + (palindromeRootNum + 1), isEven);
        long greaterDiff = Math.abs(greaterNum - num);
        
        long smallerNum = toPalindromeDigits("" + (palindromeRootNum - 1), isEven);
        long smallerDiff = Math.abs(num - smallerNum);
            
        long equalNum = toPalindromeDigits("" + palindromeRootNum, isEven);
        long equalDiff = Math.abs(equalNum - num);
        
        long minDiff = Math.min(smallerDiff, greaterDiff);
        long closestNum = smallerDiff > greaterDiff ? greaterNum :  smallerNum;
        
        if (equalDiff != 0){
            if (equalDiff == minDiff){
                closestNum  = Math.min(closestNum, equalNum);
            }else if (equalDiff < minDiff){
                closestNum = equalNum;
            }
        }
        
        return "" + closestNum;
    }
    
    public boolean allNines(String s){
        for (char c : s.toCharArray()){
            if (c != '9')
                return false;
        }
        return true;
    }
    
    public Long toPalindromeDigits(String s, boolean isEven){
        StringBuilder sb = new StringBuilder(s).reverse();
        String res = (isEven) ? s + sb.toString() : s + sb.deleteCharAt(0).toString();
        return Long.parseLong(res);
    }
}
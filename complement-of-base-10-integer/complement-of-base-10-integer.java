class Solution {
    public int bitwiseComplement(int n) {
     StringBuilder sb = new StringBuilder(Integer.toBinaryString(n));
     for (int i = 0; i < sb.length(); ++i){
         sb.setCharAt(i, (char)(((sb.charAt(i) - '0') ^ 1) + '0'));
     }
       
    
        return Integer.parseInt(sb.toString(), 2);
    }
}
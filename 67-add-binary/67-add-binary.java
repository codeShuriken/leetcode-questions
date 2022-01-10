class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1, j = b.length()-1;
        while (i >= 0 || j >= 0){
            int x = (i >= 0) ? a.charAt(i--) - '0' : 0;
            int y = (j >= 0) ? b.charAt(j--) - '0' : 0;
            int res = ((x ^ y) ^ carry);
            sb.append(res);
            carry = (x + y + carry) / 2;
        }
        
        if (carry > 0)sb.append(carry);
        return sb.reverse().toString();
    }
}
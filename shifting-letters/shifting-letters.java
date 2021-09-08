class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int[] prefix = new int[shifts.length];
        for (int i = shifts.length-1; i >= 0; --i){
            if (i == shifts.length - 1)
                prefix[i] = shifts[i];
            else
                prefix[i] = (shifts[i] + prefix[i+1]) % 26;
        }   
        
        char[] s1  = s.toCharArray();
        for (int i = 0; i < s1.length; ++i){
            int offset = (s1[i] - 'a' + prefix[i]) % 26;
            s1[i] = (char)('a' + offset);
        }
        return new String(s1);
    }
}
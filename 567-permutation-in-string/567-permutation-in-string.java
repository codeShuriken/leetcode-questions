class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] ch = new int[26];
        for (int i = 0; i < s1.length(); ++i){
            ch[s1.charAt(i) - 'a']++;
        }
        
        int start = 0, end = 0;
        int cnt = 0;
        while (end < s2.length()){
            char c = s2.charAt(end);
            if (ch[c - 'a']-- > 0){
                ++cnt;
            }
            while (cnt == s1.length()){
                if (end - start + 1 == s1.length())return true;
                c = s2.charAt(start++);
                if (ch[c - 'a']++ >= 0){
                    --cnt;
                }
            }
            ++end;
        }
        return false;
    }
}
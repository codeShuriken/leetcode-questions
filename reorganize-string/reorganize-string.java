class Solution {
    public String reorganizeString(String s) {
        int maxChar = 0;
        int maxFreq = 0;
        int[] charMap = new int[26];
        
        for (char c : s.toCharArray()){
            charMap[c - 'a']++;
            if (charMap[c-'a'] > maxFreq){
                maxFreq = charMap[c-'a'];
                maxChar = c - 'a';
            }
        }
        
        if (maxFreq > (s.length() + 1)/2)
            return "";
        
        int index = 0;
        char[] res = new char[s.length()];
        while (charMap[maxChar] > 0){
            if (index == s.length())index = 1;
            res[index] = (char)(maxChar + 'a');
            index+=2;
            charMap[maxChar]--;
        }
        
        for (int i = 0; i < charMap.length; ++i){
            while (charMap[i] > 0){
                if (index >= s.length())index = 1;
                res[index] = (char)(i + 'a');
                index += 2;
                charMap[i]--;
            }
        }
        
        return new String(res);
        
    }
}
class Solution {
    public String reverseWords(String s) {
        s = s.replaceAll("\\s{2,}", " ").trim();
        String[] words = s.split(" ");
        int start = 0, end= words.length-1;
        while (start < end){
            swap(words, start++, end--);
        }
        
        return String.join(" ", words);
    }
    
    private void swap(String[] words, int i, int j){
        String temp = words[i];
        words[i] = words[j];
        words[j] = temp;
    }
}
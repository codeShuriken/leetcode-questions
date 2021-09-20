class Solution {
    private static final String[] belowTen = {"", "One", "Two", "Three", "Four", "Five", 
                                              "Six", "Seven", "Eight", "Nine"};
    
    private static final String[] belowTwenty= {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    
    private static final String[] belowHundred = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    private static final String[] aboveHundred = {" Hundred ", " Thousand ", " Million ", " Billion "};
    
    public String numberToWords(int num) {
        if (num == 0)return "Zero";
        return numberToWordsUtil(num);
    }
    
    private String numberToWordsUtil(int num){
        String res = new String();
        if (num < 10){
            res += belowTen[num];
        }else if (num < 20){
            res += belowTwenty[num-10];
        }else if (num < 100){
            res += belowHundred[num / 10] + " " + belowTen[num % 10];
        }else if (num < 1000){
            res += numberToWordsUtil(num / 100) + aboveHundred[0] + numberToWordsUtil(num % 100);
        }else if (num < 1_000_000){
                       res += numberToWordsUtil(num / 1000) + aboveHundred[1] + numberToWordsUtil(num % 1000);
 
        }else if (num < 1_000_000_000){
             res += numberToWordsUtil(num / 1_000_000) + aboveHundred[2] + numberToWordsUtil(num % 1_000_000);
        }else{
            res += numberToWordsUtil(num / 1_000_000_000) + aboveHundred[3] + numberToWordsUtil(num % 1_000_000_000);
        }
        
        return res.trim();
    }
}
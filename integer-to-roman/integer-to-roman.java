class Solution {
    public String intToRoman(int num) {
        String[] symbols = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] nums = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        
        int index = symbols.length - 1;
        
        StringBuilder sb = new StringBuilder();
        
        while (num > 0){
            while (num - nums[index] >= 0){
                sb.append(symbols[index]);
                num -= nums[index];
            }
            index--;
        }
        
        return sb.toString();
    }
}
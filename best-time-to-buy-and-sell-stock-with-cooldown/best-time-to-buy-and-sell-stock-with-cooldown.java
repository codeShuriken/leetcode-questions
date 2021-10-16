class Solution {
    public int maxProfit(int[] prices) {
          if (prices == null || prices.length == 0)return 0;
        int n = prices.length;
        
        int hold = -prices[0], sell = Integer.MIN_VALUE, rest = 0;
        for (int i = 1; i < n; ++i){
            int prevSold = sell;
            sell = hold + prices[i];
            hold = Math.max(hold, rest - prices[i]);
            rest = Math.max(rest, prevSold);
            
        }
        
        return Math.max(rest, sell);
    }
}
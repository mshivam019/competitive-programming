public class maxprofit {
    public int maxProfit(int[] prices) {
        int min_price = Integer.MAX_VALUE;
        int max_Profit = 0;
        for (int i = 0; i < prices.length; i++) {
            min_price = Math.min(min_price, prices[i]);
            max_Profit = Math.max(max_Profit, prices[i] - min_price);
        }
        return max_Profit;
    }
}

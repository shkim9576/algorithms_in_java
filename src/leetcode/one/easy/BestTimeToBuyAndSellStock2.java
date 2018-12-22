package leetcode.one.easy;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class BestTimeToBuyAndSellStock2 {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock2 o = new BestTimeToBuyAndSellStock2();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(o.maxProfit(prices)); //5
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        }

        return profit;
    }
}

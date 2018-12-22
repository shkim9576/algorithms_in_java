package leetcode.one.easy;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock o = new BestTimeToBuyAndSellStock();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(o.maxProfit(prices)); //5
    }

    public int maxProfit(int[] prices) {
        int low = Integer.MAX_VALUE;
        int profit = 0;

        for (int p : prices) {
            low = Math.min(low, p);
            profit = Math.max(profit, p - low);
        }

        return profit;
    }
}

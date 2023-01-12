package eightpartessay;

/**
 * 买卖股票的最佳时机含手续费（动态规划）
 * 1. 确定dp数组（dp table）以及下标的含义：️dp[i][0] 表示第i天持有股票所得（最多）现金；dp[i][1] 表示第i天不持有股票所得（最多）现金
 * 2. 确定递推公式：️dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] - prices[i]); dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee)
 * 3. dp数组如何初始化: dp[0][0] = - price[0]；dp[0][1] = 0；
 * 4. 确定遍历顺序:
 * 5. 举例推导dp数组：以下
 */
public class BestTime2BuySellStockWithFee {

    public static int bestTime2BuySellStockWithFee(int[] stocks, int fee) {
        int length = stocks.length;
        int[][] dp = new int[length][2];
        // 初始化
        dp[0][0] = -stocks[0];
        dp[0][1] = 0;
        for (int i = 1; i < stocks.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - stocks[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + stocks[i] - fee);
        }
        return dp[length - 1][1];
    }


    public static void main(String[] args) {
        int[] stocks = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        int maxValue = bestTime2BuySellStockWithFee(stocks, fee);
        System.out.println(maxValue);
    }
}

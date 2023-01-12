package eightpartessay;

/**
 * 0-1背包问题
 * 1. 确定dp数组（dp table）以及下标的含义：⚠️使用二维数组，即dp[i][j] 表示从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少
 * 2. 确定递推公式：dp[i][j] = max(dp[i-1][j], dp[i-1][j-wight[i]] + value[i]])
 * (由两个方向推出来dp[i][j]：1 不放物品i：dp[i][j] = dp[i-1][j]) 2 放物品i dp[i][j] = dp[i-1][j-wight[i]] + value[i]
 * 3. dp数组如何初始化:
 * 首先当背包容量为0时，背包能容纳的最大价值为0，即dp[i][0] = 0；
 * 其次当第o个物品时，即dp[0][j]时，当j < wight[0], dp[0][j] = 0, 当j >= wight[0], dp[0][j] = value[0]
 * 4. 确定遍历顺序: 有两个遍历的维度：物品与背包重量，先遍历 物品还是先遍历背包重量呢，其实都可以，先遍历物品更好理解
 * 5. 举例推导dp数组：以下
 */
public class Knapsack01 {

    public static void knapsack01(int[] weight, int[] value, int bagWeight) {
        int goodsSize = value.length;
        int[][] dp = new int[goodsSize][bagWeight + 1];

        // dp数组初始化
        for (int i = 0; i < goodsSize; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= bagWeight; j++) {
            if (j < weight[0]) {
                dp[0][j] = 0;
                continue;
            }
            dp[0][j] = value[0];
        }
        // 遍历
        for (int i = 1; i < goodsSize; i++) {
            int weighti = weight[i];
            for (int j = 1; j <= bagWeight; j++) {
                if (j < weighti) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weighti] + value[i]);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.println("dp" + i + j + "=" + dp[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 40};
        int bagWeight = 4;
        knapsack01(weight, value, bagWeight);
    }

}

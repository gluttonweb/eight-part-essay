package eightpartessay;

/**
 * 0-1背包问题解法2
 * 1. 确定dp数组（dp table）以及下标的含义：dp[j] 表示容量为j的背包装的物品价值最大为dp[j]
 * 2. 确定递推公式：dp[j] = max(dp[j-wight[i]] + value[i], dp[j])
 * (dp[j] 相当于 二维dp数组中的dp[i-1][j]，即不放物品i，
 * 一个是取dp[j - weight[i]] + value[i]，即放物品i，指定是取最大的，毕竟是求最大价值)
 * 3. dp数组如何初始化: dp[0] = 0；
 * 4. 确定遍历顺序: 二维dp遍历的时候，背包容量是从小到大，而一维dp遍历的时候，背包是从大到小。
 * ⚠️倒序遍历是为了保证物品i只被放入一次！如果正序遍历了，那么物品0就会被重复加入多次，可自行测试
 * 5. 举例推导dp数组：以下
 */
public class Knapsack012 {

    public static void knapsack012(int[] weight, int[] value, int bagWeight) {
        int goodsSize = weight.length;
        int[] dp = new int[bagWeight + 1];
        // 初始化
        dp[0] = 0;
        // 遍历
        for (int i = 0; i < goodsSize; i++) {
            int weighti = weight[i];
            for (int j = bagWeight; j > 0; j--) {
                if (j < weighti) {
                    dp[j] = dp[j];
                    continue;
                }
                dp[j] = Math.max(dp[j], dp[j - weighti] + value[i]);
            }
        }
        for (int j = 0; j <= bagWeight; j++) {
            System.out.println(dp[j]);
        }
    }

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 40};
        int bagWeight = 4;
        knapsack012(weight, value, bagWeight);
    }
}

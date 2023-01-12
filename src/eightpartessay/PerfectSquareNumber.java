package eightpartessay;

/**
 * 完全平方数（类完全背包）
 * 1. 确定dp数组（dp table）以及下标的含义：dp[j] 表示和为j的完全平方数的最少数量
 * 2. 确定递推公式：dp[j] = Min(dp[j], dp[j - i * i] + 1)
 * 3. dp数组如何初始化: dp[0] = 0；⚠️从递归公式dp[j] = min(dp[j - i * i] + 1, dp[j]);中可以看出每次dp[j]都要选最小的，
 * 所以非0下标的dp[j]一定要初始为最大值，这样dp[j]在递推的时候才不会被初始值覆盖。
 * 4. 确定遍历顺序: 先外层for循环遍历物品（完全平方数），内层for遍历背包（和为j的完全平方数）
 * 5. 举例推导dp数组：以下
 */
public class PerfectSquareNumber {
    public static int perfectSquareNumber(int target) {
        int[] dp = new int[target + 1];
        // 初始化
        int max = Integer.MAX_VALUE;
        for (int j = 1; j < dp.length; j++) {
            dp[j] = max;
        }
        dp[0] = 0;
        // 遍历
        for (int i = 1; i * i <= target; i++) {
            for (int j = 1; j <= target; j++) {
                if (j < i * i) {
                    continue;
                }
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int target = 12;
        int nums = perfectSquareNumber(target);
        System.out.println(nums);
    }

}

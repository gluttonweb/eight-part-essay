package eightpartessay;

/**
 * 打家劫舍
 * 1. 确定dp数组（dp table）以及下标的含义：dp[i] 表示考虑下标i（包括i）以内的房屋，最多可以偷窃的金额为dp[i]。
 * 2. 确定递推公式：dp[i] = Max(dp[i - 1], dp[i - 2] + money[i])
 * ⚠️(如果偷第i房间，那么dp[i] = dp[i - 2] + money[i] ，即：第i-1房一定是不考虑的，找出 下标i-2（包括i-2）以内的房屋，最多可以偷窃的金额为dp[i-2] 加上第i房间偷到的钱。
 * 如果不偷第i房间，那么dp[i] = dp[i - 1]，即考虑i-1房，（注意这里是考虑，并不是一定要偷i-1房，这是很多同学容易混淆的点）)
 * 3. dp数组如何初始化: dp[0] = money[0]；dp[1] = max(money[0], money[1])
 * ⚠️(从递推公式dp[i] = max(dp[i - 2] + money[i], dp[i - 1]);可以看出，递推公式的基础就是dp[0] 和 dp[1]
 * 从dp[i]的定义上来讲，dp[0] 一定是 money[0]，dp[1]就是money[0]和money[1]的最大值即：dp[1] = max(money[0], money[1]))
 * 所以非0下标的dp[j]一定要初始为最大值，这样dp[j]在递推的时候才不会被初始值覆盖。
 * 4. 确定遍历顺序: dp[i] 是根据dp[i - 2] 和 dp[i - 1] 推导出来的，那么一定是从前到后遍历
 * 5. 举例推导dp数组：以下
 */
public class Rob {

    public static int rob(int[] money) {
        int houseNum = money.length;
        int[] dp = new int[houseNum];
        // 初始化
        dp[0] = money[0];
        dp[1] = Math.max(money[0], money[1]);
        for (int i = 2; i < money.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i]);
        }
        return dp[houseNum - 1];
    }

    public static void main(String[] args) {
        int[] money = {1, 2, 3, 1};
        int maxMoney = rob(money);
        System.out.println(maxMoney);
    }
}

package eightpartessay;

/**
 * 爬楼梯 （Febbonacci）
 * 1 确认dp数组：dp[i] 表示爬到第i级台阶需要 dp[i]种方法
 * 2 确认递归公式：dp[i] = dp[i - 1] + dp[i - 2]
 * 3 如何初始化：dp[0] = 0 dp[1] = 1
 * 4 遍历顺序：从小到大递归
 */
public class ClimbStairs {

    public static int climbStairs(int stairs) {
        int[] dp = new int[stairs + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= stairs; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[stairs];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}

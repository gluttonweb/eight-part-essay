package eightpartessay;

import java.util.Arrays;

/**
 * 打家劫舍II
 * ⚠️ 核心在于题目分析：
 * 对于一个数组，成环的话主要有如下三种情况：情况一：考虑不包含首尾元素；情况二：考虑包含首元素，不包含尾元素；情况三：考虑包含尾元素，不包含首元素
 * 而情况二 和 情况三 都包含了情况一了，所以只考虑情况二和情况三就可以了。
 * 而情况二和情况三解法直接服用打家劫舍{@link Rob}即可
 */
public class Rob2 {

    public static int rob2(int[] money) {
        int length = money.length;
        int[] left = Arrays.copyOfRange(money, 0, length - 1);
        int[] right = Arrays.copyOfRange(money, 1, length);
        return Math.max(rob(left), rob(right));
    }

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
        int maxMoney = rob2(money);
        System.out.println(maxMoney);
    }
}

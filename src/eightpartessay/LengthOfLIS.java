package eightpartessay;

import java.util.Arrays;

/**
 * 最长递增子序列（动态规划）
 * 1. 确定dp数组（dp table）以及下标的含义：️dp[i] 表示i之前包括i的以nums[i]结尾最长上升子序列的长度
 * 2. 确定递推公式：️j < i,dp[i] = max(dp[i], dp[j] + 1)
 * 3. dp数组如何初始化: ⚠️都为1
 * 4. 确定遍历顺序:
 * 5. 举例推导dp数组：以下
 */
public class LengthOfLIS {

    public static int lengthOfLIS(int[] array) {
        int length = array.length;
        int[] dp = new int[length];
        //初始化 ⚠️需要将dp值都初始化为1
        Arrays.fill(dp, 1);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] <= array[j]) {
                    continue;
                }
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int maxLength = 1;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > maxLength) {
                maxLength = dp[i];
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 0, 3, 2, 3};
        int length = lengthOfLIS(array);
        System.out.println(length);
    }
}

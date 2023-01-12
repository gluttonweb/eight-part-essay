package eightpartessay;

import java.util.Arrays;

/**
 * 最长连续递增子序列（动态规划）
 * 1. 确定dp数组（dp table）以及下标的含义：️dp[i] 表示i之前包括i的以nums[i]结尾最长上升子序列的长度
 * 2. 确定递推公式：如果 nums[i + 1] > nums[i]，那么以 i+1 为结尾的数组的连续递增的子序列长度一定等于以i为结尾的数组的连续递增的子序列长度 + 1。
 * 即：dp[i + 1] = dp[i] + 1;
 * 注意这里就体现出和动态规划：最长递增子序列 ({@link LengthOfLIS})的区别！因为本题要求连续递增子序列，
 * 所以就必要比较nums[i + 1]与nums[i]，而不用去比较nums[j]与nums[i] （j是在0到i之间遍历）。
 * 既然不用j了，那么也不用两层for循环，本题一层for循环就行，比较nums[i + 1] 和 nums[i]。
 * 3. dp数组如何初始化: 都为1
 * 4. 确定遍历顺序:
 * 5. 举例推导dp数组：以下
 */
public class LengthOfLCIS {

    public static int lengthOfLIS(int[] array) {
        int length = array.length;
        int[] dp = new int[length];
        //初始化 ⚠️需要将dp值都初始化为1
        Arrays.fill(dp, 1);
        for (int i = 0; i < length - 1; i++) {
            if (array[i] < array[i + 1]) {
                dp[i + 1] = dp[i] + 1;
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
        int[] array = {1, 3, 5, 4, 7};
        int length = lengthOfLIS(array);
        System.out.println(length);
    }
}

package eightpartessay;

/**
 * 最长重复子数组（动态规划）
 * 1. 确定dp数组（dp table）以及下标的含义：dp[i][j] 表示以下标i为结尾的A，和以下标j为结尾的B，最长重复子数组长度
 * 2. 确定递推公式：当A[i - 1] 和B[j - 1]相等的时候, dp[i][j] = dp[i - 1][j - 1] + 1
 * 3. dp数组如何初始化:
 * 根据dp[i][j]的定义，dp[i][0] 和dp[0][j]其实都是没有意义的！
 * 但dp[i][0] 和dp[0][j]要初始值，因为为了方便递归公式dp[i][j] = dp[i - 1][j - 1] + 1;
 * 所以dp[i][0] 和dp[0][j]初始化为0。
 * 4. 确定遍历顺序:
 * 5. 举例推导dp数组：以下
 */
public class MaximumLengthofRepeatedSubarray {

    public static int maximumLengthofRepeatedSubarray(int[] a, int[] b) {
        int aLength = a.length;
        int bLength = b.length;
        int[][] dp = new int[aLength + 1][bLength + 1];
        // 初始化
        int maxLength = 0;
        for (int i = 0; i < aLength; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < bLength; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i < aLength + 1; i++) {
            for (int j = 1; j < bLength + 1; j++) {
                // ⚠️这里是判断a[i - 1]和b[j - 1]而非a[i]和b[j]，否则会丢失a[0]和b[0]是否相等的判断。
                // 相应的遍历长度也从aLength变成aLength + 1，bLength变成bLength + 1
                if (a[i - 1] == b[j - 1]) {
                    maxLength = Math.max(maxLength, dp[i][j] = dp[i - 1][j - 1] + 1);
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 1};
        int[] b = {3, 2, 1, 4, 7};
        int maxLength = maximumLengthofRepeatedSubarray(a, b);
        System.out.println(maxLength);

    }
}

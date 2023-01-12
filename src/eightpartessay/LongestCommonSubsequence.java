package eightpartessay;

/**
 * 最长公共子序列（动态规划）
 * 1. 确定dp数组（dp table）以及下标的含义：dp[i][j] 表示以下标i为结尾的A，和以下标j为结尾的B，最长公共子序列的长度
 * 2. 确定递推公式：
 * 主要就是两大情况： text1[i - 1] 与 text2[j - 1]相同，text1[i - 1] 与 text2[j - 1]不相同
 * 1如果text1[i - 1] 与 text2[j - 1]相同，那么找到了一个公共元素，所以dp[i][j] = dp[i - 1][j - 1] + 1;
 * 2如果text1[i - 1] 与 text2[j - 1]不相同，
 * 那就看看text1[0, i - 2]与text2[0, j - 1]的最长公共子序列 和 text1[0, i - 1]与text2[0, j - 2]的最长公共子序列，取最大的。
 * 即：dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
 * 3. dp数组如何初始化: text1[0, i-1]和空串的最长公共子序列自然是0，所以dp[i][0] = 0;同理dp[0][j]也是0。
 * 4. 确定遍历顺序: 那么为了在递推的过程中，这三个方向都是经过计算的数值，所以要从前向后，从上到下来遍历这个矩阵。
 * 5. 举例推导dp数组：以下
 */
public class LongestCommonSubsequence {
    public static int longestCommonSubsequence(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        int[][] dp = new int[aLength + 1][bLength + 1];
        // 初始化
        for (int i = 0; i < aLength + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < bLength + 1; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= aLength ; i++) {
            char aChar = a.charAt(i - 1);
            for (int j = 1; j <= bLength; j++) {
                char bChar = b.charAt(j - 1);
                if (aChar == bChar) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[aLength][bLength];
    }

    public static void main(String[] args) {
        String a = "abcde";
        String b = "ace";
        int maxLength = longestCommonSubsequence(a, b);
        System.out.println(maxLength);
    }
}

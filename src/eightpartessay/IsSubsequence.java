package eightpartessay;

/**
 * 判断子序列（动态规划）（编辑距离）
 * 1. 确定dp数组（dp table）以及下标的含义：dp[i][j]表示以下标i-1为结尾的字符串s，和以下标j-1为结尾的字符串t，相同子序列的长度为dp[i][j]。
 * 2. 确定递推公式：s[i] = s[j], dp[i][j] = dp[i - 1][j - 1] + 1，s[i] != s[j], dp[i][j] = dp[i][j-1]
 * 3. dp数组如何初始化: dp[0][0] = 0；dp[i][0] = 0
 * 从递推公式可以看出dp[i][j]都是依赖于dp[i - 1][j - 1] 和 dp[i][j - 1]，所以dp[0][0]和dp[i][0]是一定要初始化的。
 * 4. 确定遍历顺序: 同理从递推公式可以看出dp[i][j]都是依赖于dp[i - 1][j - 1] 和 dp[i][j - 1]，那么遍历顺序也应该是从上到下，从左到右
 * 5. 举例推导dp数组：以下
 */
public class IsSubsequence {

    public static boolean isSubsequence(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        int[][] dp = new int[aLength + 1][bLength + 1];
        // 初始化
        for (int i = 0; i <= aLength; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= aLength; i++) {
            char aChar = a.charAt(i - 1);
            for (int j = 1; j <= bLength; j++) {
                char bChar = b.charAt(j - 1);
                if (aChar == bChar) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
                System.out.println("dp" + i + j + "=" + dp[i][j]);
            }
        }
        return dp[aLength][bLength] == aLength;
    }

    public static void main(String[] args) {
        String a = "abc";
        String b = "aaabbbgdc";
        boolean isSubsequence = isSubsequence(a, b);
        System.out.println(isSubsequence);
    }
}

package eightpartessay;

/**
 * 两个字符串的删除操作（动态规划）（编辑距离）
 * 1. 确定dp数组（dp table）以及下标的含义：以i-1为结尾的字符串word1，和以j-1位结尾的字符串word2，想要达到相等，所需要删除元素的最少次数。
 * 2. 确定递推公式：
 * word1[i-1] = word2[j-1], dp[i][j] = dp[i-1][j-1]
 * word1[i-1] != word2[j-1], 删除word1[i-1]：dp[i][j] = dp[i-1][j] + 1；删除word2：dp[i][j] = dp[i][j-1] + 1。
 * 即 dp[i][j] = min(dp[i-1][j],dp[i][j-1]) + 1
 * 3. dp数组如何初始化: dp[i][0] = i; dp[0][j] = j
 * （可以看出来，dp[i][0] 和 dp[0][j]是一定要初始化的。
 * dp[i][0]：word2为空字符串，以i-1为结尾的字符串word1要删除多少个元素，才能和word2相同呢，很明显dp[i][0] = i。dp[0][j]的话同理）
 * 4. 确定遍历顺序: 从递推公式 dp[i][j] = min(dp[i - 1][j - 1] + 2, min(dp[i - 1][j], dp[i][j - 1]) + 1);和dp[i][j] = dp[i - 1][j - 1]
 * 可以看出dp[i][j]都是根据左上方、正上方、正左方推出来的。所以遍历的时候一定是从上到下，从左到右，这样保证dp[i][j]可以根据之前计算出来的数值进行计算。
 * 5. 举例推导dp数组：以下
 */
public class DeleteOperationFor2Strings {
    public static int deleteOperationFor2Strings(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        int[][] dp = new int[aLength + 1][bLength + 1];
        // 初始化
        for (int i = 0; i <= aLength; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= bLength; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= aLength; i++) {
            char aChar = a.charAt(i - 1);
            for (int j = 1; j <= bLength; j++) {
                char bChar = b.charAt(j - 1);
                if (aChar == bChar) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[aLength][bLength];
    }

    public static void main(String[] args) {
        String a = "sea";
        String b = "eat";
        int min = deleteOperationFor2Strings(a, b);
        System.out.println(min);
    }
}

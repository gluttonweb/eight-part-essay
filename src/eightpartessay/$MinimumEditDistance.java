package eightpartessay;

/**
 * 编辑距离（动态规划）（编辑距离）
 * 1. 确定dp数组（dp table）以及下标的含义：dp[i][j]表示以下标i-1为结尾的字符串word1，和以下标j-1为结尾的字符串word2，最近编辑距离为dp[i][j]。
 * 2. 确定递推公式：
 * word1[i - 1] == word2[j - 1]，dp[i][j] = dp[i-1][j-1]
 * word1[i - 1] == word2[j - 1]，删除操作：dp[i][j] = dp[i-1][j] + 1；插入操作：dp[i][j] = dp[i][j-1] + 1；替换操作：dp[i][j] = dp[i-1][j-1] + 1
 * （⚠️word1删除一个元素，那么就是以下标i - 2为结尾的word1 与 j-1为结尾的word2的最近编辑距离 再加上一个操作。即 dp[i][j] = dp[i - 1][j] + 1;
 * word1添加一个元素，相当于word2删除一个元素，即 dp[i][j] = dp[i][j - 1] + 1。例如 word1 = "ad" ，word2 = "a"，
 * word1删除元素'd' 和 word2添加一个元素'd'，最终的操作数是一样！
 * word1替换元素，word1替换word1[i - 1]，使其与word2[j - 1]相同，此时不用增加元素，那么以下标i-2为结尾的word1 与 j-2为结尾的word2的最近编辑距离
 * 加上一个替换元素的操作。即 dp[i][j] = dp[i - 1][j - 1] + 1;
 * 综上，当 if (word1[i - 1] != word2[j - 1]) 时取最小的，即：dp[i][j] = min({dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]}) + 1）
 * 3. dp数组如何初始化: dp[i][0] = i; dp[0][j] = j;
 * (dp[i][0] ：以下标i-1为结尾的字符串word1，和空字符串word2，最近编辑距离为dp[i][0]。
 * 那么dp[i][0]就应该是i，对word1里的元素全部做删除操作，即：dp[i][0] = i; 同理dp[0][j] = j)
 * 4. 确定遍历顺序: 先遍历背包还是先遍历物品都可以
 * 5. 举例推导dp数组：以下
 */
public class $MinimumEditDistance {

    public static int minimunEditDistance(String a, String b) {
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
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[aLength][bLength];
    }

    public static void main(String[] args) {
        String a = "intention";
        String b = "execution";
        int min = minimunEditDistance(a, b);
        System.out.println(min);
    }
}

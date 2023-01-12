package eightpartessay;

/**
 * 一和零（类0-1背包问题）
 * ⚠️虽然解决方案使用的是双指针，但其实是因为此问题有两个纬度：m个o和n个1，放到0-1背包问题应该用三指针解决，此处使用双指针解决其实是使用了
 * 0-1背包问题的单指针解决方案，所以注意在第二层遍历时应该是倒叙遍历
 * 1. 确定dp数组（dp table）以及下标的含义：dp[i][j] 表示最多有i个0和j个1的strs的最大子集的大小为dp[i][j]
 * 2. 确定递推公式：dp[i][j] = max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1)
 * （dp[i][j] 可以由前一个strs里的字符串推导出来，strs里的字符串有zeroNum个0，oneNum个1。
 * dp[i][j] 就可以是 dp[i - zeroNum][j - oneNum] + 1。然后我们在遍历的过程中，
 * 取dp[i][j]的最大值。即dp[i][j] = max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1)）
 * 3. dp数组如何初始化: 01背包的dp数组初始化为0就可以。因为物品价值不会是负数，初始为0，保证递推的时候dp[i][j]不会被初始值覆盖。
 * 4. 确定遍历顺序: 01背包一定是外层for循环遍历物品，内层for循环遍历背包容量且从后向前遍历！(单指针解决方案！)
 * 5. 举例推导dp数组：以下
 */
public class $OneAndZero {

    public static int oneAndZero(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        // 初始化
        int zeroNum;
        int oneNum;
        for (String str : strs) {
            zeroNum = 0;
            oneNum = 0;
            // 计算当前字符串所含0和1的个数
            for (char ch : str.toCharArray()) {
                if ('0' == ch) {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }
            //倒序遍历
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        int maxSubCount = oneAndZero(strs, m, n);
        System.out.println(maxSubCount);
    }
}

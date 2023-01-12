package review;

/**
 * 整数拆分
 * 1. 确定dp数组（dp table）以及下标的含义：dp[i]表示：分拆数字i，可以得到的最大乘积
 * 2. 确定递推公式：⚠️：刚开始我推导的是 dp[i] = dp[j] * dp[i-j] 修正：如果定义dp[i - j] * dp[j] 也是默认将一个数强制拆成4份以及4份以
 * 上了，而且j从1开始遍历，所以可以将dp[j]的复杂度并入dp[i-j]，所以最终递推公式为：
 * dp[i] = max(j * dp[i-j], j * (i-j), dp[i]), 新增j * (i-j) 是因为 j * dp[i-j]代表拆分了两个以上 而j * (i-j) 代表拆分了两个，
 * 为什么还要比较dp[i]呢，因为在递推公式推导的过程中，每次计算dp[i]，取最大的而已。
 * 3. dp数组如何初始化: dp[0]、dp[1] 没有意义，dp[2] = 1
 * 4. 确定遍历顺序: dp[i] = j * dp[i-j] 所以先计算出dp[i-j]
 * 5. 举例推导dp数组：以下
 */
public class IntegerPartition {
    public static void main(String[] args) {
        int i = 2;
        System.out.println(integerPartition(i));
    }

    public static int integerPartition(int a) {
        int dpi = 1;
        int i_j;
        for (int j = a - 1; j > 0; j--) {
            i_j = a - j;
            if (i_j == 1) {
                dpi =  max(dpi, j * i_j);
            } else if (i_j == 2) {
                dpi = max(dpi, max(j * i_j, j * 1));
            } else {
                dpi = max(dpi, max(j * i_j, j * integerPartition(i_j)));
            }
        }
        return dpi;
    }

    public static int max(Integer a, Integer b) {
        return a.compareTo(b) >= 0 ? a : b;
    }
}

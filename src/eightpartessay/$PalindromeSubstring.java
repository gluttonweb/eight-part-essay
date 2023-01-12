package eightpartessay;

/**
 * 回文子串（动态规划）
 * 1. 确定dp数组（dp table）以及下标的含义：⚠️dp[i][j]表示区间范围[i,j]（注意是左闭右闭）的子串是否是回文子串，如果是dp[i][j]为true，否则为false。
 * 2. 确定递推公式：
 * （当s[i]与s[j]不相等，那没啥好说的了，dp[i][j]一定是false。
 * 当s[i]与s[j]相等时，这就复杂一些了，有如下三种情况
 * 情况一：下标i 与 j相同，同一个字符例如a，当然是回文子串
 * 情况二：下标i 与 j相差为1，例如aa，也是回文子串
 * 情况三：下标：i 与 j相差大于1的时候，例如cabac，此时s[i]与s[j]已经相同了，我们看i到j区间是不是回文子串就看aba是不是回文就可以了，
 * 那么aba的区间就是 i+1 与 j-1区间，这个区间是不是回文就看dp[i + 1][j - 1]是否为true。）
 * 3. dp数组如何初始化: dp[i][j]初始化为false
 * 4. 确定遍历顺序: 从递推公式中可以看出，情况三是根据dp[i + 1][j - 1]是否为true，在对dp[i][j]进行赋值true的。
 * dp[i + 1][j - 1] 在 dp[i][j]的左下角,所以一定要从下到上，从左到右遍历，这样保证dp[i + 1][j - 1]都是经过计算的。
 * 有的代码实现是优先遍历列，然后遍历行，其实也是一个道理，都是为了保证dp[i + 1][j - 1]都是经过计算的。
 * 5. 举例推导dp数组：以下
 */
public class $PalindromeSubstring {

    public static int palindromeSubString(String str) {
        int length = str.length();
        boolean[][] dp = new boolean[length][length];
        // 初始化
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                dp[i][j] = false;
            }
        }
        int subNum = 0;
        // ⚠️注意遍历顺序
        for (int j = 0; j < length; j++) {
            for (int i = 0; i <= j; i++) {
                if (str.charAt(i) == str.charAt(j)) {
                    if (i == j) {
                        dp[i][j] = true;
                        subNum++;
                    } else if (j - i == 1) {
                        dp[i][j] = true;
                        subNum++;
                    } else if (j - i > 1) {
                        dp[i][j] = dp[i + 1][j - 1];
                        if (dp[i][j]) {
                            subNum++;
                        }
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return subNum;
    }

    public static void main(String[] args) {
        String str = "abc";
        int subNum = palindromeSubString(str);
        System.out.println(subNum);
    }

    // todo 双指针中心扩展法
}

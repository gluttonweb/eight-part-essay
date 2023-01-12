package eightpartessay;

import java.util.HashSet;
import java.util.Set;

/**
 * 单词拆分（类完全背包）
 * （单词就是物品，字符串s就是背包，单词能否组成字符串s，就是问物品能不能把背包装满。）
 * 拆分时可以重复使用字典中的单词，说明就是一个完全背包！
 * 1. 确定dp数组（dp table）以及下标的含义：字符串长度为j的话，dp[j]为true，表示可以拆分为一个或多个在字典中出现的单词。
 * 2. 确定递推公式：如果确定dp[j] 是true，且 [j, i] 这个区间的子串出现在字典里，那么dp[i]一定是true。（j < i ）。
 * 所以递推公式是 if([j, i] 这个区间的子串出现在字典里 && dp[j]是true) 那么 dp[i] = true。
 * 3. dp数组如何初始化: dp[0] = true；dp[j](j > 0) = false
 * (从递归公式中可以看出，dp[i] 的状态依靠 dp[j]是否为true，那么dp[0]就是递归的根基，dp[0]一定要为true，否则递归下去后面都是false了。
 * 下标非0的dp[i]初始化为false，只要没有被覆盖说明都是不可拆分为一个或多个在字典中出现的单词。)
 * 4. 确定遍历顺序: 先遍历背包还是先遍历物品都可以
 * 5. 举例推导dp数组：以下
 */
public class $WordSplitting {

    public static boolean wordSplitting(String s, String[] wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(wordSet);
        // 初始化
        for (int j = 1; j < dp.length; j++) {
            dp[j] = false;
        }
        dp[0] = true;
        for (int j = 1; j <= s.length(); j++) {
            for (String word : wordDict) {
                int wordLength = word.length();
                if (j >= wordLength && dp[j - wordLength] && s.substring(j - wordLength, j).equals(word)) {
                    dp[j] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        String[] workDict = {"leet", "code"};
        boolean result = wordSplitting(s, workDict);
        System.out.println(result);
    }
}

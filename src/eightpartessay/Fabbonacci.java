package eightpartessay;

import java.math.BigDecimal;
import java.util.Random;

/**
 * 斐波那契数列
 */
public class Fabbonacci {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        String split = " ";
        int k = new Random().nextInt(100);
        System.out.println(k);
//        int k = 100;
        BigDecimal before = new BigDecimal(1);
        BigDecimal beforeBefore =  new BigDecimal(1);
        BigDecimal fn;
        if (k <= 0) {
            System.out.println("项数不能小于1");
            return;
        }
        sb.append(beforeBefore);
        if (k == 1) {
            System.out.println(sb);
            return;
        }
        sb.append(split).append(before);
        if (k == 2) {
            System.out.println(sb);
            return;
        }
        for (int n = 3; n <= k; n++) {
            fn = before.add(beforeBefore) ;
            sb.append(split).append(fn);
            System.out.println(sb);
            beforeBefore = before;
            before = fn;
        }
    }


}

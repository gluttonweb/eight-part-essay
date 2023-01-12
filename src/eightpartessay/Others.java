package eightpartessay;

import java.util.HashMap;

public class Others {

    public static void main(String[] args) {
        dd();
    }

    public static void dd() {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(3, 3);
        map.put(5, 5);
        map.put(7, 7);
        for (int i = 0; i < 100; i++) {
            if (i < 10) {
                if (null != map.get(i)) {
                    continue;
                }
                System.out.println(i);
                continue;
            }
            int onesPalace = i % 10;
            if (null != map.get(onesPalace)) {
                continue;
            }
            System.out.println(i);
        }
    }
}

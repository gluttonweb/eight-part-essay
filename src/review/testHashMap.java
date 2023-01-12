package review;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.BrokenBarrierException;

public class testHashMap {

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put(1, 1);
        hashMap.put(null, 2);
        System.out.println(hashMap.get(null));

        Hashtable<Object, Object> hashTable = new Hashtable<>();
        hashTable.put(null, 1);
        System.out.println(hashTable.get(null));
    }
}

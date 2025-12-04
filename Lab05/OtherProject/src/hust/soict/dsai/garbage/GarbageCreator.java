package hust.soict.dsai.garbage;

import java.util.Random;

public class GarbageCreator {
    public static void main(String[] args) {
        Random r = new Random(123);
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 1000000; i++) {
            s += (char) r.nextInt();
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}

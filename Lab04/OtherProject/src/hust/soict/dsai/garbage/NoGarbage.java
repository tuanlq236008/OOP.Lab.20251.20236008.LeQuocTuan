package hust.soict.dsai.garbage;

import java.util.Random;

public class NoGarbage {
    public static void main(String[] args) {
        Random r = new Random(123);
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            sb.append((char) r.nextInt());
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}
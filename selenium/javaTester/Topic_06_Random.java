package javaTester;

import java.util.Random;

public class Topic_06_Random {
    // Java Builtin (Cung cấp sẵn - Lấy ra sử dụng)
    // Java Libraries (Do cá nhân hoặc 1 tổ chức họ viết)

    public static void main(String[] args) {
        Random rand = new Random();

        System.out.println(rand.nextInt());

        System.out.println("camkhang.bk.hust" + rand.nextInt(99999) + "@gmail.com");
        System.out.println("camkhang.bk.hust" + rand.nextInt(99999) + "@gmail.com");
        System.out.println("camkhang.bk.hust" + rand.nextInt(99999) + "@gmail.com");
        System.out.println("camkhang.bk.hust" + rand.nextInt(99999) + "@gmail.com");
    }
}



import java.util.Scanner;

public class OddEvenGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int even = 0, odd = 0;

        while (true) {
            int num = sc.nextInt();
            if (num == 0) {
                return;
            }

            if (num % 2 == 0) {
                ++even;
            } else {
                ++odd;
            }

            System.out.println("Even = " + even);
            System.out.println("Odd = " + odd);
            sc.close();
        }
    }

}

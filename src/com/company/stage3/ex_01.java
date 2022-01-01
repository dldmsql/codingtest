package com.company.stage3;

import java.util.Scanner;

public class ex_01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if( n >= 1 && n <= 9) {
            for (int i = 1; i < 10; i++) {
                System.out.println(n + " * " + i + " = " + n * i);
            }
        }
    }
}

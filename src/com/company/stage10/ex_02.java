package com.company.stage10;

import java.util.Scanner;

public class ex_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibo(n));
    }

    private static int fibo(int n) {
        // f(0) = 0, f(1) = 1, f(n) = f(n-1) + f(n-2)
        if( n < 0) return -1;
        if( n<= 1) return n;
        return fibo(n-2)+fibo(n-1);
    }
}

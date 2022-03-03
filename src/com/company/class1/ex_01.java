package com.company.class1;

import java.util.Scanner;

public class ex_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(func1(n));
    }

    private static int func1(int n) {
        int sum = 0;
        for( int i = 1; i <= n; i++ ){
            if( i%3 == 0 || i%5 == 0 ) sum += i;
        }
        return sum;
    }
}

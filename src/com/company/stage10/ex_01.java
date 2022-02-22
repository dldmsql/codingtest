package com.company.stage10;

import java.util.Scanner;

public class ex_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int in = sc.nextInt();

        System.out.println(fact(in));
    }

    private static int fact(int in) {
        if( in < 0 ) return -1;
        if( in == 0) return 1;
        if( in <= 1) return in;
        return in*fact(in-1);
    }
}

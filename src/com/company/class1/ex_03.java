package com.company.class1;

import java.util.Scanner;

public class ex_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(func3(n));
    }

    private static int func3(int n) {
        if(n%Math.sqrt(n) == 0) return 1;
        else return 0;
    }
    private static int fun(int n){
        for( int i = 1; i*i <= n; i++){
            if( i*i == n) return 1;
        }
        return 0;
    }
}

package com.company.class1;

import java.util.Scanner;

public class ex_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(func4(n));
    }

    private static int func4(int n){
      // 생각이 안나
        int result = 1;
        while( 2*result <= n ) result *= 2;
        return result;
    }

}

package com.company.stage3;

import java.util.Scanner;

public class ex_06 {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if( n > 0 && n <= 100000 ){
            for(int i = 0; i < n; i++){
                System.out.println(n-i);
            }
        }
    }

}

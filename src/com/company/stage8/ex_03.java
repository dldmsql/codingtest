package com.company.stage8;

import java.util.Scanner;

public class ex_03 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a =1;
        int b =1;
        int range = 1;
        int cnt = 1;
        if (n != 1) {
            while (n >= range) {
                range = range + cnt;
                cnt++;
            }
                a = cnt- (range-n) ;
                b = cnt-a;
        }
        int temp;
        if( cnt%2 == 0 ) {
            temp = a;
            a = b;
            b = temp;
        }
        System.out.println(a + "/" + b);
    }
}

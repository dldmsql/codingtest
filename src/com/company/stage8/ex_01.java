package com.company.stage8;

import java.util.Scanner;

public class ex_01 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        long a = Long.parseLong(input[0]); // 고정 비용 
        long b = Long.parseLong(input[1]); // 가변 비용 - 1대 당
        long c = Long.parseLong(input[2]); // 판매 가격 - 1대 당

        System.out.println(calcualte(a,b,c));
    }

    private static long calcualte(long a, long b, long c) {
        if( b >= c ){ // 1대 만드는 데 들어가는 가변 비용이 판매가격보다 크면, 남는 게 없다.
            return -1;
        } else {
            long n = a / ( c - b); // 손익분기점
            return n+1;
        }
    }
}

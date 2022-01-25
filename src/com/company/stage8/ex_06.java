package com.company.stage8;

import java.util.Scanner;

public class ex_06 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i =0; i < t; i++){
            int k = sc.nextInt();
            int n = sc.nextInt();

            System.out.println(self(k,n));

        }

    }
    private static int self(int k, int n) {
        // 층수 k
        // 호수 n
        int sum = 0;
        if( k == 0 ) { // 0층일 경우,
           for(int i =1; i<= n; i++){
               sum = i; // i가 곧 호수이다.
           }
           return sum;
        }
        for(int i =1; i<=n; i++){ // 호수만큼 반복
            sum += self(k-1, i); // i가 곧 호수이다. 재귀적으로 sum에 더해간다.
        }
        return sum;
    }
}

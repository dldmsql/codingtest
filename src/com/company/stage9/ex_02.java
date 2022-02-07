package com.company.stage9;

import java.util.Scanner;

public class ex_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int sum = 0;
        int min = 0;

        for(int i = m; i <= n; i++){

            boolean isN = true;
            int s = (int) Math.sqrt(i);

            if( i == 1) continue;

            for( int j = 2; j <= s; j++){
                if(i%j == 0){
                    isN = false;
                    break;
                }
            }

            if(isN){
                if( min == 0 ) min = i;
                sum += i;
            }
        }
        if( min != 0 ) {
            System.out.println(sum);
            System.out.println(min);
        } else System.out.println(-1);
    }
}

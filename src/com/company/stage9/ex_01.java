package com.company.stage9;

import java.util.Scanner;

public class ex_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;

        for(int i =0; i< n; i++) {
            int t = sc.nextInt();
            int s = (int) Math.sqrt(t);
            boolean isN = true;

            if( t == 1){
                continue;
            }
                for( int j =2; j<= s; j++){
                    if(t % j == 0) {
                        isN = false;
                        break;
                    }
                }

            if(isN){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}

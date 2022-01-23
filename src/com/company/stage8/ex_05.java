package com.company.stage8;

import java.util.Scanner;

public class ex_05 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tN = Integer.parseInt(sc.nextLine());
        int[] result = new int[tN];
        for(int i = 0; i< tN; i++){
            String[] test;
            test = sc.nextLine().split(" ");

            int h = Integer.parseInt(test[0]);
            int w = Integer.parseInt(test[1]);
            int n = Integer.parseInt(test[2]);

            for( int j = 1; j <= w; j++){
                if( n > h) {
                    n = n - h;
                } else {
                    result[i] = n*100 + j;
                    break;
                }
            }
        }
        for(Integer in : result){
            System.out.println(in);
        }
    }
}

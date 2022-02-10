package com.company.stage9;

import java.util.Scanner;

public class ex_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        for(int i = m; i <= n; i++){
            if(i == 1){
                continue;
            }
            boolean isN = true;
            for(int j = 2; j <= (int)Math.sqrt(i); j++){
                if(i%j == 0){
                    isN = false;
                    break;
                }
            }
            if(isN){
                System.out.println(i);
            }
        }
    }
}

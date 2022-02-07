package com.company.stage9;

import java.util.Scanner;

public class ex_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = 2;

        while(n !=1){
            if(n%k == 0){
                System.out.println(k);
                n /= k;
            }else k++;
        }
    }

}

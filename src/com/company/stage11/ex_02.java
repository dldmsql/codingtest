package com.company.stage11;

import java.util.Scanner;

public class ex_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;
        for( int i = (n - (String.valueOf(n).length()*9)); i < n; i++ ){
            int temp = i;
            int sum = 0;

            while(temp != 0){
                sum += temp%10;
                temp/=10;
            }

            if( (sum + i) == n){
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}

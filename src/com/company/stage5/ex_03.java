package com.company.stage5;

import java.util.Scanner;

public class ex_03 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = Integer.parseInt(sc.nextLine());
        int b = Integer.parseInt(sc.nextLine());
        int c = Integer.parseInt(sc.nextLine());

        int cnt[] = {0 , 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        if( !(a < 100 || b < 100 || c < 100) ) {
            String result =  String.valueOf(a*b*c);
            char[] results = result.toCharArray();
            for(int i = 0; i<results.length; i++){
               for(int j = 0; j < 10; j++) {
                   if (Integer.parseInt(String.valueOf(results[i])) == j) cnt[j]++;
               }
            }
            for(Integer i : cnt) {
                System.out.println(i);
            }
        }
    }

}

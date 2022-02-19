package com.company.stage9;

import java.util.Arrays;
import java.util.Scanner;

public class ex_09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int a = sc.nextInt();
            int b= sc.nextInt();
            int c = sc.nextInt();
            if( a <= 0 &&  b <= 0 && c <= 0){
                break;
            }
            int[] in = {a,b,c};
            Arrays.sort(in);

            if( in[2]*in[2] == in[0]*in[0] + in[1]*in[1] ){
                System.out.println("right");
            } else System.out.println("wrong");
        }
    }


}

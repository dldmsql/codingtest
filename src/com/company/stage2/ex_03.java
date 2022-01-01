package com.company.stage2;

import java.util.Scanner;

public class ex_03 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        if(input >= 1 && input <= 4000 ){
        if (input%400 == 0 || (input%4==0 &&input%100 !=0)) System.out.println(1);
        else  System.out.println(0);

        }
    }
}
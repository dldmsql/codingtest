package com.company.stage1;

import java.util.Scanner;

public class ex_11 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();
        String input = sc.nextLine();
        String[] inputs = input.split("");
        int a = Integer.parseInt(inputs[0])*100;
        int b = Integer.parseInt(inputs[1])*10;
        int c = Integer.parseInt(inputs[2]);
        int first = Integer.parseInt(input1);
        System.out.println(first*c);
        System.out.println(first*b/10);
        System.out.println(first*a/100);
        System.out.println(first*(a+b+c));
    }
}

package com.company.stage1;

import java.util.Scanner;

public class ex_08 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] inputs = input.split(" ");
        double a = Integer.parseInt(inputs[0]);
        double b = Integer.parseInt(inputs[1]);
        double result = a/b;
        System.out.println(result);

    }
}

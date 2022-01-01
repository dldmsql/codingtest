package com.company.stage2;

import java.util.Scanner;

public class ex_01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] inputs = input.split(" ");
        int a = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);
        if( a > b ) System.out.println(">");
        else if( a == b ) System.out.println("==");
        else if ( a < b ) System.out.println("<");
    }
}
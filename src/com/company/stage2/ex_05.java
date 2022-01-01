package com.company.stage2;

import java.util.Scanner;

public class ex_05 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] inputs = input.split(" ");
        int h = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        if( (h >= 0 && h <= 23) && ( m >= 0 && m<= 59) ) {
            if( m >= 45 ) System.out.println(h + " " + (m-45));
            else {
                if ( h == 0 ) System.out.println(23 + " " + (m + 15));
                else System.out.println((h - 1) + " " + (m + 15));
            }
        }

    }
}
package com.company.stage3;

import java.util.Scanner;

public class ex_02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < t; i++){
            String inputs = sc.nextLine();
            String[] input = inputs.split(" ");
            System.out.println(Integer.parseInt(input[0]) + Integer.parseInt(input[1]));
        }
    }
}

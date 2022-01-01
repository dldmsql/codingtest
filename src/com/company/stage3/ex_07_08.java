package com.company.stage3;

import java.util.Scanner;

public class ex_07_08 {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < t; i++){
            String inputs = sc.nextLine();
            String[] input = inputs.split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            System.out.println("Case #"+ (i+1) +": "+ a +" + " + b + " = " + (a+b));
        }
    }

}

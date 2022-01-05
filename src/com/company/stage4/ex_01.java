package com.company.stage4;

import java.util.Scanner;

public class ex_01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while(flag){
            int[] ns = splitToInt(sc.nextLine());
            if(ns[0] == 0 && ns[1] == 0) flag = false;
            else System.out.println(ns[0] + ns[1]);
        }
    }
    public static int[] splitToInt(String input){
        String[] inputs = input.split(" ");
        int[] ns = new int[2];
        ns[0] = Integer.parseInt(inputs[0]);
        ns[1] = Integer.parseInt(inputs[1]);
        return ns;
    }
}

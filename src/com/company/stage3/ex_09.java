package com.company.stage3;

import java.util.Scanner;

public class ex_09 {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for(int i = 1; i < t+1; i++){
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }

    }

}

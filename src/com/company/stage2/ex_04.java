package com.company.stage2;

import java.util.Scanner;

public class ex_04 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String input2 = sc.nextLine();
        int x = Integer.parseInt(input);
        int y = Integer.parseInt(input2);
        if(x >= -1000 && x <= 1000 || x != 0 || y !=0 || y >= -1000 && y <= 1000){
        if (x >0 && y >0) System.out.println(1);
        else if(x > 0 && y < 0) System.out.println(4);
        else if(x < 0 && y> 0) System.out.println(2);
        else if (x < 0 && y < 0) System.out.println(3);
        }
    }
}